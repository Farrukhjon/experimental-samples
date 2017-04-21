package org.farrukh.experiments;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WebClientUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebClientUtil.class);

    private static final int MAX = 30;
    CloseableHttpClient httpClient = null;
    private HttpContext context = new BasicHttpContext();
    public static final String URL = "";
    private String host = "localhost";
    private String path = "books";
    private int port = 8989;

    public WebClientUtil() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(MAX);
        httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .build();

    }

    public CloseableHttpResponse request(String id) throws IOException {
        CloseableHttpResponse response = null;
        try {
            URI uri = createUriByPath(id);
            HttpGet request = new HttpGet(uri);
            request.addHeader(new BasicHeader("accept", "application/json; charset=utf-8"));
            LOGGER.info("Executing request to url: {}", uri);
            response = httpClient.execute(request);
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
        } finally {
            response.close();
        }
    }

    private URI createUriByPath(String id) {
        try {
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
