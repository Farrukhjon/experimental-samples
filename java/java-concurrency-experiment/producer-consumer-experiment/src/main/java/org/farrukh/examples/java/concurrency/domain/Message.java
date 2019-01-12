package org.farrukh.examples.java.concurrency.domain;

public class Message {

    private final String from;
    private final String to;
    private final String data;

    public Message(String from, String to, String data) {
        this.from = from;
        this.to = to;
        this.data = data;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
