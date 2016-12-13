package org.farrukh.experiments.java.net.completion;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class Server {
    
    private static final int PORT = 80;
    
    private AsynchronousServerSocketChannel server;

    
    public Server() {
        try {
            AsynchronousChannelGroup group = new ServerChannelGroup(new ServerChannelProvider());
            server = AsynchronousServerSocketChannel.open(group);
            SocketAddress address = new InetSocketAddress(PORT);
            server.bind(address);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Future<AsynchronousSocketChannel> result = server.accept();
    }
    
    public static void main(String[] args) {
        new Server().start();
    }


}
