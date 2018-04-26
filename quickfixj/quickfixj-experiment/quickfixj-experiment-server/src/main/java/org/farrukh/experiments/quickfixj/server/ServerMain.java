package org.farrukh.experiments.quickfixj.server;

public class ServerMain {
    
    public static void main(String[] args) {
        ServerMessageAcceptor app = new ServerMessageAcceptor();
        app.start();
    }

}
