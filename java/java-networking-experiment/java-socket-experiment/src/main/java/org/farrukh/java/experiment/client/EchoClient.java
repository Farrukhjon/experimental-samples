package org.farrukh.java.experiment.client;

import org.farrukh.java.experiment.App;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {

    private final String host;
    private final int serverPort;

    public EchoClient(String host, int serverPort) {
        this.host = host;
        this.serverPort = serverPort;
    }

    public void start(final String message) {
        try (Socket clientSocket = new Socket(host, serverPort);
             PrintWriter outStream = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader inStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            outStream.println(message);
            String dataFromServer;
            while ((dataFromServer = inStream.readLine()) != null) {
                System.out.println("Server replayed:" + dataFromServer);
                if ("Fine".equals(dataFromServer)) {
                    break;
                }
                outStream.println("How are u?");
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        new EchoClient(App.HOST, App.SERVER_PORT)
                .start("Hello World!");
    }

}
