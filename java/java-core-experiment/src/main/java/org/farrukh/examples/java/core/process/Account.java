package org.farrukh.examples.java.core.process;

public class Account {

    private final String username;
    private final String password;
    private final String host;
    private final int port;

    public Account(final String username,
                   final String password,
                   final String host,
                   final int port) {
        this.password = password;
        this.username = username;
        this.host = host;
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }
}
