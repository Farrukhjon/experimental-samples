package org.farrukh.experiments;

import org.apache.http.client.methods.HttpGet;
import org.junit.*;
import org.mockserver.integration.ClientAndServer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

import static org.apache.http.HttpHeaders.ACCEPT;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;
import static org.junit.Assert.assertNotNull;
import static org.mockserver.model.HttpCallback.callback;
import static org.mockserver.model.HttpRequest.request;

public class AppTest {

    private static ClientAndServer mockServer;

    @BeforeClass
    public static void setUpEnv() throws Exception {
        System.setProperty("connection.host", "localhost");
        System.setProperty("connection.port", "8989");
    }

    @BeforeClass
    public static void startHttpServer() throws Exception {
        Integer port = Integer.valueOf(System.getProperty("connection.port"));
        mockServer = ClientAndServer.
                startClientAndServer(port);
        mockServer
                .when(
                        request()
                                .withMethod(HttpGet.METHOD_NAME)
                                .withHeader(ACCEPT, APPLICATION_JSON.toString())
                                .withPath("")
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
        Set<Future<Book>> futures = new HashSet<Future<Book>>();
        List<String> ids = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            ids.add(String.valueOf(i));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletionService<Book> completionService = new ExecutorCompletionService<Book>(executorService);
        for (String id : ids) {
            Callable<Book> requestTask = new RequestBookTask(id);
            Future<Book> bookFuture = completionService.submit(requestTask);
            futures.add(bookFuture);
        }
        while (!futures.isEmpty()) {
            Future<Book> future = completionService.take();
            if (future.isDone()) {
                Book book = future.get();
                assertNotNull(book);
                assertNotNull(book.getId());
                assertNotNull(book.getName());
                futures.remove(future);
            }
        }
    }

}
