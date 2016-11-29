package org.farrukh.examples.java.networking.proxy;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;

public class SocksProxyClientExample {

    public static void main(String[] args) {
        int proxyPort = 0;
        String proxyHost = "localhost";
        Socket socksProxySocket = new Socket(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(proxyHost, proxyPort)));

    }

    private static Proxy setupSocksProxy(final String proxyHost, final int proxyPort) {
        return new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(proxyHost, proxyPort));
    }

    private static Socket setupSocket(final Proxy proxy) {
        return new Socket(proxy);
    }

    private static void setupConnection(final Socket socket, final String host, int port) {
        try {
            socket.connect(new InetSocketAddress(host, port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static OutputStream setupIO(final Socket socket) {
        OutputStream outputStream = null;
        try {
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream;
    }

}
