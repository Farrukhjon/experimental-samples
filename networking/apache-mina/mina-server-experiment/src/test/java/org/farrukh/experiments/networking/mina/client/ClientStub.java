package org.farrukh.experiments.networking.mina.client;

import java.net.InetSocketAddress;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.transport.socket.SocketConnector;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

public class ClientStub {

    private static final long TIMEOUT = 2 * 1000L;

    private static final int SERVER_PORT = 9090;

    private final SocketConnector connector;

    private ConnectFuture connectFuture;

    public ClientStub() {
        connector = new NioSocketConnector();
        connector.setConnectTimeoutMillis(TIMEOUT);
        connector.setDefaultRemoteAddress(new InetSocketAddress(SERVER_PORT));
        connector.setHandler(new ClientMessageHandler());
    }

    public void start() {
        connectFuture = connector.connect();
    }

    public void send(final String message) {
        IoSession session = connectFuture.getSession();
        session.write(message);
    }

}
