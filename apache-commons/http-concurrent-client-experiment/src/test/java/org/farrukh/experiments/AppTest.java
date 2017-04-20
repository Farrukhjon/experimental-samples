package org.farrukh.experiments;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppTest {

    @Before
    public void initHttpServer() throws Exception {
        HttpRestServer.init();
    }

    @Test
    public void testConcurrentThreadSafeRequesting() throws Exception {
        List<Future<Book>> futures = new ArrayList<Future<Book>>();

        List<String> ids = Arrays.asList("1", "2", "3");
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (String id : ids) {
            Callable<Book> requestTask = new RequestBookTask(id);
            Future<Book> bookFuture = executorService.submit(requestTask);
            futures.add(bookFuture);
        }
        for (Future<Book> future : futures) {
            if (future.isDone()) {
                Book book = future.get();
                Assert.assertNotNull(book);
            }
        }
    }

}
