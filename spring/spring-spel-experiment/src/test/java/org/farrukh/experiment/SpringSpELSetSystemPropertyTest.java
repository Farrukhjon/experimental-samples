package org.farrukh.experiment;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:system-prop-context.xml")
public class SpringSpELSetSystemPropertyTest {


    @Autowired
    Book book;

    @Autowired
    Book book2;

    @BeforeClass
    public static void setUp() throws Exception {
        String cmaSeparatedStrAuthors = "Ali, Vali, Surayo, Muhayo";
        System.setProperty("book.authors", cmaSeparatedStrAuthors);

        System.setProperty("book2.authors", "Sami, Gani");
    }

    @Test
    public void testBook() {
        List<String> authors = book.getAuthors();
        assertEquals(4, authors.size());
    }

    @Test
    public void testBook2() {
        List<String> authors = book2.getAuthors();
        assertEquals(2, authors.size());
    }

}
