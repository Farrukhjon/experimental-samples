package immutable;

public final class Apple {

    private final String color;

    public Apple(final String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Apple{");
        sb.append("color='")
          .append(color)
          .append('\'');
        sb.append('}');
        return sb.toString();
    }
}
