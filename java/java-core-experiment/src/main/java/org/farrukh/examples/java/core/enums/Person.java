package org.farrukh.examples.java.core.enums;

public class Person {

    private final String name;
    private final Gender gender;

    public Person(final Gender gender, final String name) {
        this.gender = gender;
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }
}
