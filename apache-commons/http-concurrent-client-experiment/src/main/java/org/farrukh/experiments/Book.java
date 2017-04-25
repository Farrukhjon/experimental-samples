package org.farrukh.experiments;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Book {

    @JsonProperty
    private String id;

    @JsonProperty
    private String name;

    @JsonProperty
    private List<Author> authors;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", authors=").append(authors);
        sb.append('}');
        return sb.toString();
    }
}
