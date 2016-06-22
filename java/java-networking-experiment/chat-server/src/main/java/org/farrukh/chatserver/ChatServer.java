package org.farrukh.chatserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ChatServer {

    private static final Logger logger = LoggerFactory.getLogger(ChatServer.class);

    private final List<ChatHandler> clients;
    private final ServerSocket serverSocket;

    public ChatServer(List<ChatHandler> clients, ServerSocket serverSocket) {
        this.clients = clients;
        this.serverSocket = serverSocket;
    }

    public void runServer() {
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                String hostName = clientSocket.getInetAddress().getHostName();
                logger.info("Accepted from {}", hostName);
                clients.add(new ChatHandler(clientSocket, hostName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
