package org.farrukh.experiments;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {

    @JsonProperty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
