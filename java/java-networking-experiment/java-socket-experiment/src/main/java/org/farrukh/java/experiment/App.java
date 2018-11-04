package org.farrukh.java.experiment;

import org.farrukh.java.experiment.client.EchoClient;
import org.farrukh.java.experiment.server.EchoServer;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    private static final int SERVER_PORT = 1025;
    private static final String HOST = "localhost";
    private final EchoClient echoClient;
    private final EchoServer echoServer;

    public App() throws IOException {
        echoServer = new EchoServer(SERVER_PORT);
        echoClient = new EchoClient(HOST, SERVER_PORT);
    }

    public EchoClient getEchoClient() {
        return echoClient;
    }

    public EchoServer getEchoServer() {
        return echoServer;
    }

    public static void main(String[] args) throws IOException {
        App app = new App();

        String message = "Hello World!";

        EchoServer echoServer = app.getEchoServer();

        echoServer.start();

        EchoClient echoClient = app.getEchoClient();

        echoClient.sendMessage(message);

    }

}
