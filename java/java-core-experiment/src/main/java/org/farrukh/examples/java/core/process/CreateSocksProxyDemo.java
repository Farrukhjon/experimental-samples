package org.farrukh.examples.java.core.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Runtime.getRuntime;

public class CreateSocksProxyDemo {

    public static final String SSHPASS = "sshpass ";
    public static final String SSH = " ssh -nfN -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null -o ConnectTimeout=30 -o LogLevel=ERROR -D ";

    public static void main(String[] args) throws IOException, InterruptedException {
        Account account = new Account("root", "Df7t59Fgcm", "37.220.38.105", 22);
        int bindPort = 41410;
        String bindAddress = "127.0.0.1";
        createSocks(account, bindAddress, bindPort);
    }

    private static void createSocks(final Account account, String bindAddress, int bindPort) throws IOException, InterruptedException {
        String password = account.getPassword();
        String remoteUsername = account.getUsername();
        String remoteHost = account.getHost();
        String remotePort = String.valueOf(account.getPort());
        final String cmd = new StringBuilder().append(SSHPASS)
                                              .append(" -p ")
                                              .append(password)
                                              .append(SSH)
                                              .append(bindAddress)
                                              .append(":")
                                              .append(bindPort)
                                              .append(" ")
                                              .append(remoteUsername)
                                              .append("@")
                                              .append(remoteHost)
                                              .append(" -p ")
                                              .append(remotePort)
                                              .toString();
        final Process process = getRuntime().exec(cmd);
        process.waitFor();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

}
