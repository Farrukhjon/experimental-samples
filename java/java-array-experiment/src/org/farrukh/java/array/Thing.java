package org.farrukh.java.array;

public class Thing {

    private final String name;

    public Thing(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Thing: " + this.name;
    }

    public String getName() {
        return name;
    }
}
