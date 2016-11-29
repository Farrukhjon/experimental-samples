package org.farrukh.chatserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatHandler implements Runnable {

    private final Socket clientSocket;
    private final BufferedReader input;
    private final PrintWriter output;
    private final String clientIP;

    public ChatHandler(Socket clientSocket, String clientIP) throws IOException {
        this.clientSocket = clientSocket;
        this.clientIP = clientIP;
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        output = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    @Override
    public void run() {

    }
}
