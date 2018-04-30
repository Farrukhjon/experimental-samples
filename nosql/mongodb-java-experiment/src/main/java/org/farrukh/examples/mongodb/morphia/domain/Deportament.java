package org.farrukh.examples.mongodb.morphia.domain;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Deportament {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
