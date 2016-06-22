package org.farrukh.examples.java.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadingDirectlyFromURL {

    @Test
    public void shouldReadingFileDirectlyFromURL() throws IOException {
        URL url = new URL("https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html");
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            Assert.assertNotNull(line);
        }
        reader.close();
    }
}
