package org.farrukh.experiment;

import java.util.Collections;
import java.util.List;

public class Book {

    private List<String> authors;

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        if(null == authors) {
            authors = Collections.emptyList();
        }
        this.authors = authors;
    }
}
