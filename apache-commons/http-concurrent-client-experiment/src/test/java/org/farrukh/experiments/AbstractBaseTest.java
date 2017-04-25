package org.farrukh.experiments;

import org.apache.http.client.methods.HttpGet;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public abstract class AbstractBaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractBaseTest.class);

    private static ClientAndServer mockServer;

    @BeforeClass
    public static void setUpEnv() throws Exception {
        System.setProperty("connection.host", "localhost");
        System.setProperty("connection.port", "8989");
    }

    @BeforeClass
    public static void startHttpServer() throws Exception {
        Integer port = Integer.valueOf(System.getProperty("connection.port"));
        LOGGER.info("Starting The Mock Server on port: {}", port);
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

}
