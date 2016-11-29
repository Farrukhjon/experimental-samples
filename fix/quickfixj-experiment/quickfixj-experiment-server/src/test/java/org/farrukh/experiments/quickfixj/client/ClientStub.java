package org.farrukh.experiments.quickfixj.client;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.Message;
import quickfix.field.ApplVerID;
import quickfix.field.HeartBtInt;
import quickfix.field.SenderCompID;
import quickfix.field.SenderSubID;
import quickfix.field.TargetCompID;
import quickfix.field.TargetSubID;
import quickfix.fixt11.Logon;

public class ClientStub {

    Logger logger = LoggerFactory.getLogger(ClientStub.class);

    Socket socket;

    Thread sender;

    Thread receiver;

    public ClientStub() {
        socket = new Socket();
        try {
            SocketAddress endpoint = new InetSocketAddress("localhost", 9090);
            socket.connect(endpoint);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        receiver = new Thread() {
            @Override
            public void run() {
                receive();
            }
        };
        receiver.start();
    }

    // write
    private void send(String message) {
        if (socket.isConnected()) {
            try (OutputStream outputStream = socket.getOutputStream()) {
                outputStream.write(message.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // read
    private void receive() {
        if (socket.isConnected()) {
            try {
                InputStream socketInput = socket.getInputStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(socketInput);
                ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
                int lastByte;
                while (true) {
                    while ((lastByte = bufferedInputStream.read()) > 0) {
                        byteArrayOutput.write(lastByte);
                    }
                    String receivedMsg = new String(byteArrayOutput.toByteArray());
                    logger.info("Resecived message is: {}", receivedMsg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendLogon() {
        Message.Header header = createHeader();
        Logon logon = new Logon();
        logon.setFields(header);
        send(logon.toString());
    }

    private Message.Header createHeader() {
        Message.Header header = new Message.Header();
        header.setField(new SenderCompID("CLIENT"));
        header.setField(new TargetCompID("SERVER"));
        header.setField(new SenderSubID("CLIENT-SUB-ID"));
        header.setField(new TargetSubID("SERVER-SUB-ID"));
        header.setField(new ApplVerID(ApplVerID.FIX50SP2));
        header.setField(new HeartBtInt(30));
        return header;
    }

    public void stop() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
