package org.farrukh.examples.java.nio.channel.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelDemo {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(999));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().getLocalSocketAddress();


        SocketChannel socketChannel = serverSocketChannel.accept();
        if(socketChannel != null) {

        }
    }
}
