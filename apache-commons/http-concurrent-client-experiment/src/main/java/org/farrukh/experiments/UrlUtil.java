package org.farrukh.experiments;

import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class UrlUtil {

    private static String path = "books";

    public static URI createUriByPath(String id) {
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
