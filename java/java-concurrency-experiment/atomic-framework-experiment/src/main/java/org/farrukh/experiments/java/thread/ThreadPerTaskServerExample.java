package org.farrukh.experiments.java.thread;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Farrukhjon on 19-Sep-15.
 */
public class ThreadPerTaskServerExample {

    public static void main(String[] args) {
        new ThreadPerTaskServerExample().run();
    }

    private static void handlaRequest(Socket connection) {
        try {
            InputStream inputStream = connection.getInputStream();
            int data;
            while ((data = inputStream.read()) > 0) {
                System.out.printf(String.valueOf((char) data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            try (ServerSocket socket = new ServerSocket(1010)) {
                while (true) {
                    Socket connection = socket.accept();
                    Runnable task = () ->
                            handlaRequest(connection);
                    new Thread(task).start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
