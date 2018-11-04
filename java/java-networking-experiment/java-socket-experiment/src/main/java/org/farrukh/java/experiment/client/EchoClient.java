package org.farrukh.java.experiment.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {


    private final Socket clientSocket;

    public EchoClient(String host, int serverPort) throws IOException {
        clientSocket = new Socket(host, serverPort);
    }

    public void sendMessage(final String message) throws IOException {
        byte[] bytes = message.getBytes();
        OutputStream outStream = clientSocket.getOutputStream();
        outStream.write(bytes);
        outStream.flush();
        outStream.close();
        clientSocket.close();
    }

}
