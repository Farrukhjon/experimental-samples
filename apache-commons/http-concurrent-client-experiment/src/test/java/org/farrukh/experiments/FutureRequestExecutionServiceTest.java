package org.farrukh.experiments;

import org.apache.http.HttpHeaders;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.FutureRequestExecutionMetrics;
import org.apache.http.impl.client.FutureRequestExecutionService;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.apache.http.entity.ContentType.APPLICATION_JSON;

public class FutureRequestExecutionServiceTest extends AbstractBaseTest {

    private static final int CONN_TOTAL = 20;

    private static final int MAX_CONN_PER_ROUTE = 20;

    private static final int N_THREADS = 7;

    @Test
    public void shouldSendRequestSimultaneously() throws Exception {
        HttpClient httpClient = HttpClients.custom()
                .setMaxConnTotal(CONN_TOTAL)
                .setMaxConnPerRoute(MAX_CONN_PER_ROUTE)
                .build();
        ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);
        FutureRequestExecutionService futureRequestExecutionService = new FutureRequestExecutionService(httpClient, executorService);
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            String bookId = String.valueOf(i);
            URI path = UrlUtil.createUriByPath(bookId);
            HttpGet request = new HttpGet(path);
            request.addHeader(HttpHeaders.ACCEPT, APPLICATION_JSON.toString());
            futureRequestExecutionService.execute(request, null, new BookResponseHandler(), new BookFutureCallback(latch));
        }
        latch.await();
        FutureRequestExecutionMetrics metrics = futureRequestExecutionService.metrics();
    }

}
