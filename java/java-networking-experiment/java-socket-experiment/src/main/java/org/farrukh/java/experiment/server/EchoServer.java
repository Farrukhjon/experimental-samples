package org.farrukh.java.experiment.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private final ServerSocket serverSocket;
    private Socket clientSocket;

    public EchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() {
        System.out.println("Starting server...");
        Thread thread = new Thread(() -> {
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from a client");
                InputStream inStream = clientSocket.getInputStream();
                int data;
                StringBuilder result = new StringBuilder();
                while ((data = inStream.read()) != -1) {
                    result.append(String.valueOf((char) data));
                }
                System.out.println(result.toString());
                inStream.close();
                clientSocket.close();
            } catch (IOException e) {
                System.err.println(e);
            }

        });
        thread.start();
    }

}
