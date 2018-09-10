package org.farrukh.experiment;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:system-prop-context.xml")
public class SpringSpELSetSystemPropertyTest {


    @Autowired
    Book book;

<<<<<<< HEAD
    @Value("#{systemProperties[abc].split(',')}")
    private List<String> aListFromArrayProvidedBySystemproperties;
=======
    @Autowired
    Book book2;
>>>>>>> 49ade6e5886040f45870683bda597d3038ae2b43

    @BeforeClass
    public static void setUp() throws Exception {
        String cmaSeparatedStrAuthors = "Ali, Vali, Surayo, Muhayo";
        System.setProperty("book.authors", cmaSeparatedStrAuthors);
<<<<<<< HEAD
        System.setProperty("abc", "A,B,C");

=======

        System.setProperty("book2.authors", "Sami, Gani");
>>>>>>> 49ade6e5886040f45870683bda597d3038ae2b43
    }

    @Test
    public void testBook() {
        List<String> authors = book.getAuthors();
        assertEquals(4, authors.size());
    }

    @Test
<<<<<<< HEAD
    public void test1() {
        List<String> aListFromArrayProvidedBySystemproperties = this.aListFromArrayProvidedBySystemproperties;
        String[] expected = {"A", "B", "C"};
        String[] actual = aListFromArrayProvidedBySystemproperties.toArray(new String[]{});

        assertArrayEquals(expected, actual);
    }
=======
    public void testBook2() {
        List<String> authors = book2.getAuthors();
        assertEquals(2, authors.size());
    }

>>>>>>> 49ade6e5886040f45870683bda597d3038ae2b43
}
