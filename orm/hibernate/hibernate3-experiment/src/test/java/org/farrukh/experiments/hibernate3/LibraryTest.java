package org.farrukh.experiments.hibernate3;

import org.farrukh.experiments.hibernate3.model.library.Author;
import org.farrukh.experiments.hibernate3.model.library.Book;
import org.hibernate.Session;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class LibraryTest extends AbstractBaseTest {


    @Test
    public void test() {
        Author author = doInHibernate(new Function<Session, Author>() {
            @Override
            public Author apply(Session session) {
                return (Author) session.get(Author.class, new Long(900));
            }
        });

        author.setName("Sami");

        doInHibernate(new Consumer<Session>() {
            @Override
            public void accept(Session session) {
                session.saveOrUpdate(author);
            }
        });


    }

    private Set<Book> aliBooks() {
        HashSet<Book> books = new HashSet<>();
        Book b1 = new Book();
        b1.setName("B1");

        Book b2 = new Book();
        b2.setName("B2");

        Book b3 = new Book();
        b3.setName("B3");

        books.add(b1);
        books.add(b2);
        books.add(b3);

        return books;
    }

    @Override
    protected String getUnitTestProperties() {
        return "oracle_unittest.properties";
    }
}
