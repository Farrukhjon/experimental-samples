package org.farrukh.examples.java.regex.parser;

public class Account {

    private final String protocol;
    private final String username;
    private final String password;
    private final String ip;
    private final int port;

    public Account(final String protocol, final String username, final String password, final String ip,
                   final int port) {
        this.protocol = protocol;
        this.username = username;
        this.password = password;
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public String getPassword() {
        return password;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getUsername() {
        return username;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("ip='")
          .append(ip)
          .append('\'');
        sb.append(", protocol='")
          .append(protocol)
          .append('\'');
        sb.append(", username='")
          .append(username)
          .append('\'');
        sb.append(", password='")
          .append(password)
          .append('\'');
        sb.append(", port=")
          .append(port);
        sb.append('}');
        return sb.toString();
    }
}
