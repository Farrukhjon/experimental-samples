package org.farrukh.experiments.hibernate3.model.library;

import javax.persistence.*;

@Entity
public class Author {

    @Id
    @SequenceGenerator(name = "AUTHOR_SEQ_ID_GENERATOR", sequenceName = "AUTHOR_SEQ_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUTHOR_SEQ_ID_GENERATOR")
    private Long id;

    @Column
    private String name;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOK_ID", nullable = false)
    private Book book;

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
