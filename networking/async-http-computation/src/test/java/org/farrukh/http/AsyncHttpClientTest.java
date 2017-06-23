package org.farrukh.http;

import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;
import org.farrukh.http.model.ResponseObject;
import org.farrukh.http.server.HttpJettyServer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Executors;

import static javax.ws.rs.core.Response.Status.OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by fsattorov on 23.06.2017.
 */
public class AsyncHttpClientTest {

    @Before
    public void startServer() throws Exception {
        new Thread(new ServerRunnable()).start();
    }

    @Test
    public void shouldSendAndHandleAsyncRequest() throws Exception {
        Thread.sleep(2 * 1000);
        String url = "http://localhost:8989/";

        Response response = new DefaultAsyncHttpClient().
                prepareGet(url).
                execute().
                addListener(new DataListener(), Executors.newSingleThreadExecutor()).
                toCompletableFuture().
                join();

        assertNotNull(response);
        assertEquals(OK.getStatusCode(), response.getStatusCode());

    }

    private class DataListener implements Runnable {

        public void run() {
            System.out.println("Async request/response is completed...");
        }

    }

    private class ServerRunnable implements Runnable {

        @Override
        public void run() {
            new HttpJettyServer();
        }

    }
}
