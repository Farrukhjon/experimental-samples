package org.farrukh.experiments;

import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.apache.http.HttpHeaders.ACCEPT;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;

public class PooledConcurrentWebClientUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(PooledConcurrentWebClientUtil.class);

    private static final int MAX_CONN_TOTAL = 20;
    private static final int MAX_CONN_PER_ROUTE = 20;

    private CloseableHttpClient httpClient = null;
    private String path = "books";

    public PooledConcurrentWebClientUtil() {
        httpClient = HttpClients.custom()
                .setConnectionManager(new PoolingHttpClientConnectionManager())
                .setMaxConnPerRoute(MAX_CONN_PER_ROUTE)
                .setMaxConnTotal(MAX_CONN_TOTAL)
                .build();
    }

    public CloseableHttpResponse request(String id) throws IOException {
        try {
            URI uri = createUriByPath(id);
            HttpGet request = new HttpGet(uri);
            request.addHeader(ACCEPT, APPLICATION_JSON.toString());
            LOGGER.info("Executing request to url: {}", uri);
            CloseableHttpResponse response = httpClient.execute(request);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            /*if (statusCode != 200) {
                throw new RuntimeException("Error response");
            }*/
            LOGGER.info("The response status code is: {}", statusCode);
            return response;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private URI createUriByPath(String id) {
        try {
            String host = System.getProperty("connection.host");
            Integer port = Integer.valueOf(System.getProperty("connection.port"));
            return new URIBuilder()
                    .setScheme("http")
                    .setHost(host)
                    .setPort(port)
                    .setPath(path)
                    .addParameter("bookId", id)
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
