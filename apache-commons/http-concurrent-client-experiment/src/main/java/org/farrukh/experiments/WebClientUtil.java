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

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class WebClientUtil {

    private static final int MAX = 30;
    CloseableHttpClient httpClient = null;
    private HttpHost target;
    private HttpContext context = new BasicHttpContext();
    public static final String URL = "";
    private String host = "localhost";
    private String path = "books";
    private int port = 8080;

    public WebClientUtil() throws IOException {
        CloseableHttpResponse response = null;
        try {
            PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
            connectionManager.setMaxTotal(MAX);
            httpClient = HttpClients.custom()
                    .setConnectionManager(connectionManager)
                    .build();
            String host = "";
            HttpHost target = HttpHost.create(host);
            String url = "";
            HttpRequest request = new HttpGet(url);


        } finally {
            httpClient.close();
            response.close();
        }
    }

    public CloseableHttpResponse request(String id) throws IOException {
        CloseableHttpResponse response = null;
        try {
            URI uri = createUriByPath(id);
            HttpGet request = new HttpGet(uri);
            request.addHeader(new BasicHeader("accept", "application/json"));
            response = httpClient.execute(target, request, context);
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() != 200) {
                throw new RuntimeException("Error response");
            }
            return response;
        } catch (IOException e) {
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
                    .setPath(id)
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
