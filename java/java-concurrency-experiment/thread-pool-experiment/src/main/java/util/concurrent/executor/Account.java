package util.concurrent.executor;

public class Account {

    private final String host;

    public Account(final String host) {
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("host='")
          .append(host)
          .append('\'');
        sb.append('}');
        return sb.toString();
    }
}
