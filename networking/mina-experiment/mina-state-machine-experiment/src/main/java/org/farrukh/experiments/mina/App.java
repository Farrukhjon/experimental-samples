package org.farrukh.experiments.mina;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.farrukh.experiments.mina.exception.StateMachineException;
import org.farrukh.experiments.mina.handler.StateMachineHandler;

/**
 * Hello world!
 *
 */
public class App {

    private static final int PORT = 9090;
    private final SocketAcceptor acceptor;

    public App(StateMachineHandler stateMachineHandler) {
        if(stateMachineHandler == null) {
            throw new IllegalArgumentException("The handler cannot be null");
        }
        acceptor = new NioSocketAcceptor();
        acceptor.setDefaultLocalAddress(new InetSocketAddress(PORT));
        acceptor.setReuseAddress(true);
        
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        acceptor.getFilterChain().addLast("protCodecFactory", new ProtocolCodecFilter(new TextLineCodecFactory(UTF_8)));
        
        IoHandler handler = stateMachineHandler.getIoHandler();
        acceptor.setHandler(handler);
    }
    
    public void start() {
        try {
            acceptor.bind();
        } catch (IOException e) {
            throw new StateMachineException(e);
        }
    }

    public static void main(String[] args) {
        App app = new App(new StateMachineHandler());
        app.start();
    }
}
