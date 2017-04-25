package org.farrukh.experiments;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.impl.client.*;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureRequestExecutionServiceTest extends AbstractBaseTest {

    private BookMapper bookMapper;

    @Before
    public void setUp() throws Exception {
        bookMapper = new BookMapper();
    }

    private static final int CONN_TOTAL = 20;
    private static final int MAX_CONN_PER_ROUTE = 20;
    private static final int N_THREADS = 7;

    @Test
    public void test() throws Exception {
        HttpClient httpClient = HttpClients.custom()
                .setMaxConnTotal(CONN_TOTAL)
                .setMaxConnPerRoute(MAX_CONN_PER_ROUTE)
                .build();
        ExecutorService executorService = Executors.newFixedThreadPool(N_THREADS);
        FutureRequestExecutionService futureRequestExecutionService = new FutureRequestExecutionService(httpClient, executorService);
        HttpContext context = new BasicHttpContext();
        ResponseHandler<?> responseHandler = new AbstractResponseHandler<Book>() {
            @Override
            public Book handleEntity(HttpEntity entity) throws IOException {
                return bookMapper.mapToBook(entity);
            }
        };

        for (int i = 0; i < 10; i++) {
            String bookId = String.valueOf(i);
            URI path = UrlUtil.createUriByPath(bookId);
            futureRequestExecutionService.execute(new HttpGet(path), context, responseHandler, new BookFutureCallback());
        }

        FutureRequestExecutionMetrics metrics = futureRequestExecutionService.metrics();
    }

}
