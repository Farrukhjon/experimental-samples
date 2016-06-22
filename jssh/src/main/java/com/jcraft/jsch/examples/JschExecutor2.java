package com.jcraft.jsch.examples;

import com.jcraft.jsch.*;

import java.io.*;

public class JschExecutor2 {

    public static void main(String[] args) {
        JschExecutor2 t = new JschExecutor2();
        try {
            t.go();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void go() throws Exception {

        StringBuilder outputBuffer = new StringBuilder();

        String host = "localhost"; // First level target
        String user = "vagrant";
        String password = "vagrant";
        String tunnelRemoteHost = "74.122.199.115"; // The host of the second target
        String secondPassword = "8FvGgC6AQY";
        int port = 22;


        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, port);
        session.setPassword(password);
        LocalUserInfo lui = new LocalUserInfo();
        session.setUserInfo(lui);
        session.setConfig("StrictHostKeyChecking", "no");
        // create port from 2233 on local system to port 22 on tunnelRemoteHost
        session.setPortForwardingL(2233, tunnelRemoteHost, 22);
        session.connect();
        session.openChannel("direct-tcpip");

        // create a session connected to port 2233 on the local host.
        Session secondSession = jsch.getSession(user, "localhost", 2233);
        secondSession.setPassword(secondPassword);
        secondSession.setUserInfo(lui);
        secondSession.setConfig("StrictHostKeyChecking", "no");

        secondSession.connect(); // now we're connected to the secondary system
        Channel channel = secondSession.openChannel("exec");
        ((ChannelExec) channel).setCommand("hostname");

        channel.setInputStream(null);

        InputStream stdout = channel.getInputStream();

        channel.connect();

        while (true) {
            byte[] tmpArray = new byte[1024];
            while (stdout.available() > 0) {
                int i = stdout.read(tmpArray, 0, 1024);
                if (i < 0) break;
                outputBuffer.append(new String(tmpArray, 0, i));
            }
            if (channel.isClosed()) {
                System.out.println("exit-status: " + channel.getExitStatus());
                break;
            }
        }
        stdout.close();

        channel.disconnect();

        secondSession.disconnect();
        session.disconnect();

        System.out.print(outputBuffer.toString());
    }

    class LocalUserInfo implements UserInfo {
        String passwd;

        public String getPassword() {
            return passwd;
        }

        public boolean promptYesNo(String str) {
            return true;
        }

        public String getPassphrase() {
            return null;
        }

        public boolean promptPassphrase(String message) {
            return true;
        }

        public boolean promptPassword(String message) {
            return true;
        }

        public void showMessage(String message) {
        }
    }
}
