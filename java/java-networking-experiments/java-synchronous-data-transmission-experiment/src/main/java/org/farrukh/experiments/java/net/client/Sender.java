package org.farrukh.experiments.java.net.client;

import java.net.Socket;

public class Sender {

    private boolean messageForSend;
    
    private Sendable sendable;

    public Sender(final Socket socket) {
        Thread senderThread = new Thread() {
            @Override
            public void run() {
                while (Boolean.TRUE) {
                    if (messageForSend) {
                        sendable.send();
                    }
                }
            }
        };
        senderThread.start();
    }

    void send(final String message) {

    }

}
