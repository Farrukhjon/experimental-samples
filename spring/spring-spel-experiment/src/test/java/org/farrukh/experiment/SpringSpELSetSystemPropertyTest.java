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

    @Value("#{systemProperties[abc].split(',')}")
    private List<String> aListFromArrayProvidedBySystemproperties;

    @BeforeClass
    public static void setUp() throws Exception {
        String cmaSeparatedStrAuthors = "Ali, Vali, Surayo, Muhayo";
        System.setProperty("book.authors", cmaSeparatedStrAuthors);
        System.setProperty("abc", "A,B,C");

    }

    @Test
    public void test() {
        List<String> authors = book.getAuthors();
        assertEquals(4, authors.size());
    }

    @Test
    public void test1() {
        List<String> aListFromArrayProvidedBySystemproperties = this.aListFromArrayProvidedBySystemproperties;
        String[] expected = {"A", "B", "C"};
        String[] actual = aListFromArrayProvidedBySystemproperties.toArray(new String[]{});

        assertArrayEquals(expected, actual);
    }
}
