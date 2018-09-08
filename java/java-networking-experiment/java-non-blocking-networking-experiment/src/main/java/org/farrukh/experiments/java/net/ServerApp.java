package org.farrukh.experiments.java.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ServerApp {

    private static final int PORT = 9090;
    private static final boolean BLOCKING = false;

    public static void main(String[] args) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        SocketAddress local = new InetSocketAddress(PORT);
        server.bind(local);

        server.configureBlocking(BLOCKING);

        SocketChannel client = server.accept();

        Selector selector = Selector.open();

        server.register(selector, SelectionKey.OP_ACCEPT);

        // non-blocking accept (server.configureBlocking(BLOCKING)) immediately
        // returns null if there are no incoming connections.
        if (client != null) {
            client.configureBlocking(BLOCKING);
            client.register(selector, SelectionKey.OP_WRITE);
        }

        while (true) {
            try {
                selector.select();
            } catch (IOException e) {
                break;
            }

            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                if (key.isAcceptable()) {
                    ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                } else if (key.isWritable()) {
                    SocketChannel clientWrite = (SocketChannel) key.channel();
                } else if (key.isReadable()) {
                    SocketChannel clientRead = (SocketChannel) key.channel();
                }
            }
        }

    }

}
