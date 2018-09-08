package org.farrukh.experiments.java.net.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerApp {

    private Logger logger = LoggerFactory.getLogger(ServerApp.class);
    
    private List<String> messages = new ArrayList<>();

    public ServerApp() {
        int port = 9090;
        try (ServerSocket server = new ServerSocket(port);
                Socket client = server.accept();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));) {
            receive(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void receive(BufferedReader reader) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                logger.info("Reading message: {}", line);
                messages.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerApp();
    }

    public List<String> getMessages() {
        return messages;
    }

}
