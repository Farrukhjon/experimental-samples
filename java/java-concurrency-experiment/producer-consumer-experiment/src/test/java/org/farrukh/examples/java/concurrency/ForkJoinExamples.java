package org.farrukh.examples.java.concurrency;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ForkJoinExamples extends TestCase {

    @Test
    public void testFileDownloaderFromWeb() throws URISyntaxException, IOException {
        URL url = new URL("https://docs.oracle.com/javase/tutorial/essential/concurrency/highlevel.html");
        InputStream inputStream = url.openStream();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        
        assertNotNull(inputStream);
        assertNotNull(url);
    }

}
