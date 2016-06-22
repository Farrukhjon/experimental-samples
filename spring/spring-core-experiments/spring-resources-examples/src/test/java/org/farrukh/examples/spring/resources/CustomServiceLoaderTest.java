package org.farrukh.examples.spring.resources;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;
import static org.springframework.util.Assert.notNull;

public class CustomServiceLoaderTest extends BaseTest {

    @Autowired
    CustomServiceLoader customServiceLoader;

    @Test
    public void testReadingResourceUsingClasspathURL() throws IOException {
        String expectedLine = "Hello world!";
        Resource resource = customServiceLoader.getResource("classpath:/test.txt");
        InputStream inputStream = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            assertEquals(expectedLine, line);
        }
        notNull(inputStream);
    }


    @Test
    public void testReadingResourceUsingFileURL() throws IOException {
        String expectedLine = "Hello world!";
        Resource resource = customServiceLoader.getResource("file:/home/vagrant/GitHub/farrukhjon/spring-examples/spring-resources-examples/src/test/resources/test.txt");
        InputStream inputStream = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            assertEquals(expectedLine, line);
        }
        notNull(inputStream);
    }

    @Test
    public void testReadingResourceFromWebUsingURL() throws IOException {
        Resource resource = customServiceLoader.getResource("url:http://docs.spring.io/spring/docs/current/javadoc-api/index.html");
        InputStream inputStream = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        notNull(inputStream);
    }

}
