package org.farrukh.experiments;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

import static org.junit.Assert.assertNotNull;

public class AppTest extends AbstractBaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

    @Test
    public void testConcurrentThreadSafeRequesting() throws Exception {
        Set<Future<Book>> futures = new HashSet<Future<Book>>();
        List<String> ids = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            ids.add(String.valueOf(i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletionService<Book> completionService = new ExecutorCompletionService<Book>(executorService);
        for (String id : ids) {
            Callable<Book> requestTask = new RequestBookTask(id);
            Future<Book> bookFuture = completionService.submit(requestTask);
            LOGGER.info("Submitting request with id: {}", id);
            futures.add(bookFuture);
        }
        while (!futures.isEmpty()) {
            Future<Book> future = completionService.take();
            if (future.isDone() && !future.isCancelled()) {
                Book book = future.get();
                assertNotNull(book);
                assertNotNull(book.getId());
                assertNotNull(book.getName());
                LOGGER.info("Expected book retrieved: {}", book);
                futures.remove(future);
            }
        }
    }

}
