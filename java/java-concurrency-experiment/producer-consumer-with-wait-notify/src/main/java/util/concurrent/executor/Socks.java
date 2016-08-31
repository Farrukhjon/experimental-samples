package util.concurrent.executor;

public class Socks {

    private final String host;

    private final int port;

    public Socks(final String host, final int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Socks{");
        sb.append("host='")
          .append(host)
          .append('\'');
        sb.append(", port=")
          .append(port);
        sb.append('}');
        return sb.toString();
    }
}
