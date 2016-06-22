package org.farrukh.examples.java.networking.proxy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

import static java.net.Proxy.Type.SOCKS;

public class DownloadFileUsingSocksProxy {

    //private static final String url = "https://www.kernel.org/pub/linux/utils/kernel/hotplug/udev-012.tar.gz";
    private static final String url = "http://translate.yandex.ru/";

    public static void main(String[] args) {
        Account account = new Account("root", "z8o1h20uuo", "64.251.10.253", 22);
        int socksPort = 3312;
        String socksHost = "127.0.0.1";
        //createSocks(account, socksHost, socksPort);
        try {
            URLConnection connection = new URL(url).openConnection(/*new Proxy(SOCKS, new InetSocketAddress(socksHost, socksPort))*/);
            try (final BufferedInputStream inputStream = new BufferedInputStream(connection.getInputStream());
                 final BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(new File("translate.html"))))
            {
                byte[] buff = new byte[1024];
                while (inputStream.available() > 0) {
                    inputStream.read(buff);
                    out.write(buff);
                }
                out.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createSocks(final Account account, String socksHost, int socksPort) {
        String password = account.getPassword();
        String remoteUsername = account.getUsername();
        String remoteHost = account.getRemoteHost();
        String remotePort = String.valueOf(account.remotePort);
        String port = String.valueOf(socksPort);
        List<String> socksCommand = Arrays.asList("sshpass", "-p" + password,
                                                  "ssh",
                                                  "-nfN",
                                                  "-o StrictHostKeyChecking=no",
                                                  "-o UserKnownHostsFile=/dev/null",
                                                  "-o ConnectTimeout=30",
                                                  "-o LogLevel=ERROR",
                                                  "-D " + socksHost + ":" + port + " " + remoteUsername + "@" + remoteHost + " -p " + remotePort);
        ProcessBuilder builder = new ProcessBuilder(socksCommand);
        try {
            Process process = builder.start();
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Account {
        private final String username;
        private final String password;
        private final String remoteHost;
        private final int remotePort;

        public Account(final String username, final String password, final String remoteHost,
                       final int remotePort) {
            this.password = password;
            this.username = username;
            this.remoteHost = remoteHost;
            this.remotePort = remotePort;
        }

        public String getPassword() {
            return password;
        }

        public String getRemoteHost() {
            return remoteHost;
        }

        public int getRemotePort() {
            return remotePort;
        }

        public String getUsername() {
            return username;
        }
    }
}
