package org.farrukh.experiments;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.mockserver.model.HttpCallback.callback;
import static org.mockserver.model.HttpRequest.request;

public class AppTest {

    private ClientAndServer mockServer;
    private Integer port = 8989;

    @Before
    public void startHttpServer() throws Exception {
        mockServer = ClientAndServer.startClientAndServer(port);
        mockServer
                .when(
                        request()
                                .withMethod("GET")
                )
                .callback(
                        callback()
                                .withCallbackClass(MockServerResponseCallback.class.getCanonicalName())
                );
    }

    @After
    public void stopHttpServer() throws Exception {
        mockServer.stop();

    }

    @Test
    public void testConcurrentThreadSafeRequesting() throws Exception {
        List<Future<Book>> futures = new ArrayList<Future<Book>>();
        List<String> ids = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            ids.add(String.valueOf(i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(17);
        for (String id : ids) {
            Callable<Book> requestTask = new RequestBookTask(id);
            Future<Book> bookFuture = executorService.submit(requestTask);
            futures.add(bookFuture);
        }
        Thread.sleep(7000);
        for (Future<Book> future : futures) {
            if (future.isDone()) {
                Book book = future.get();

                Assert.assertNotNull(book);
                Assert.assertNotNull(book.getId());
                Assert.assertNotNull(book.getName());
            }
        }
        Thread.sleep(7000);
        executorService.shutdown();
    }

}
