package org.farrukh.experiments.quickfixj.client;

public class ClientMain {

    public static void main(String[] args) {
        ClientMessageConnector msgConnector = new ClientMessageConnector();
        msgConnector.start();
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                msgConnector.sendLogoff();
                msgConnector.stop();
            }
        });
    }

}
