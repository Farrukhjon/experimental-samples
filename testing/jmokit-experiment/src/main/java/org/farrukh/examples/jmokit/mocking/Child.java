package org.farrukh.examples.jmokit.mocking;

public class Child extends Parent {

    private final String name;

    public Child(String name) {
        super(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
