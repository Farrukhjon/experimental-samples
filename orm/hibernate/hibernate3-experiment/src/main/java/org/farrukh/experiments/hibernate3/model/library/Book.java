package org.farrukh.experiments.hibernate3.model.library;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @SequenceGenerator(name = "BOOK_SEQ_ID_GENERATOR", sequenceName = "BOOK_SEQ_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_SEQ_ID_GENERATOR")
    private Long id;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
