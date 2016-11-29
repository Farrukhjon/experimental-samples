package org.farrukh.experiments.java.net.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientApp {

    public ClientApp() {
        try (Socket socket = new Socket("localhost", 9090);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
            receive(reader);

        } catch (Exception e) {
        }
    }


    public void send(String message) {
        
    }

    private void receive(BufferedReader reader) {
        // TODO Auto-generated method stub
    }

}
