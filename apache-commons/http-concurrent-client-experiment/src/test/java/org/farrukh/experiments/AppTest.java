package org.farrukh.experiments;

import org.apache.http.client.methods.HttpGet;
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

import static org.apache.http.HttpHeaders.ACCEPT;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;
import static org.mockserver.model.HttpCallback.callback;
import static org.mockserver.model.HttpRequest.request;

public class AppTest {

    private ClientAndServer mockServer;

    @Before
    public void setUpEnv() throws Exception {
        System.setProperty("connection.host", "localhost");
        System.setProperty("connection.port", "8989");
    }

    @Before
    public void startHttpServer() throws Exception {
        Integer port = Integer.valueOf(System.getProperty("connection.port"));
        mockServer = ClientAndServer.
                startClientAndServer(port);
        mockServer
                .when(
                        request()
                                .withMethod(HttpGet.METHOD_NAME)
                                .withHeader(ACCEPT, APPLICATION_JSON.toString())
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
