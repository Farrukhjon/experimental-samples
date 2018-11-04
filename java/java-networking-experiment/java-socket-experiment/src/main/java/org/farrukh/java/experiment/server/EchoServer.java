package org.farrukh.java.experiment.server;

import org.farrukh.java.experiment.App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() {
        System.out.println("Starting server...");
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            System.out.println("Accepted connection from a client");
            String dataFromClient;
            while ((dataFromClient = input.readLine()) != null) {
                System.out.println("Server received: " + dataFromClient);
                if ("Bay".equals(dataFromClient)) {
                    break;
                }
                out.println("Hi there");
                out.println("Fine");
                out.println("Bay");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        new EchoServer(App.SERVER_PORT)
                .start();
    }
}
