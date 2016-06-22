package org.farrukh.examples.java.core.process.socks;

/**
 * The object represents ssh account.
 */
public class SSHAccount {

    /**
     * The host name of a socks proxy.
     */
    private String host;

    /**
     * The username of a socks proxy.
     */
    private String username;

    /**
     * The password of a socks proxy.
     */
    private char[] password;

    public SSHAccount(final String host, final char[] password, final String username) {
        this.host = host;
        this.password = password;
        this.username = username;
    }

    public String getHost() {
        return host;
    }

    public void setHost(final String host) {
        this.host = host;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(final char[] password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Returns string representation.
     *
     * @return the string of the object description.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Socks{");
        sb.append("host='")
          .append(host)
          .append('\'');
        sb.append(", username='")
          .append(username)
          .append('\'');
        sb.append('}');
        return sb.toString();
    }

}
