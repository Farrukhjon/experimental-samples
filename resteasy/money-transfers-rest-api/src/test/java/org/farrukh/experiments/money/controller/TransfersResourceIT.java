package org.farrukh.experiments.money.controller;

import org.farrukh.experiments.money.MainApp;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Client;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;
import static javax.ws.rs.client.Entity.entity;
import static org.junit.Assert.assertEquals;

public class TransfersResourceIT {

    private static MainApp appServer;
    private static int port = 8181;
    private static javax.ws.rs.client.Client client;

    @BeforeClass
    public static void init() throws Exception {
        appServer = new MainApp(port, "localhost");
        appServer.startServer();
        client = ClientBuilder.newClient();
    }


    @Test
    public void testCreateNewAccount() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        Client c = new Client("Ali", "Valiev");
        Account account = new Account(c, "RUR", 1_000_000_000.0);
        UriBuilder uriBuilder = UriBuilder.fromPath(format("http://localhost:%s/money/accounts/create", port));
        MediaType acceptMimeType = MediaType.APPLICATION_XML_TYPE;
        MediaType contentMimType = MediaType.APPLICATION_XML_TYPE;
        Response response = client
                .target(uriBuilder)
                .request(acceptMimeType)
                .post(entity(account, contentMimType));

        assertEquals(HttpServletResponse.SC_CREATED, response.getStatus());
    }

    @Test
    public void testCreateInvalidAccount() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        Client c = new Client("Ali", "Valiev");
        Account account = new Account(c, "RUR", 1_000_000_000.0);
        UriBuilder uriBuilder = UriBuilder.fromPath(format("http://localhost:%s/money/accounts/create", port));
        MediaType acceptMimeType = MediaType.APPLICATION_XML_TYPE;
        MediaType contentMimType = MediaType.APPLICATION_XML_TYPE;
        Response response = client
                .target(uriBuilder)
                .request(acceptMimeType)
                .post(entity(account, contentMimType));

        assertEquals(HttpServletResponse.SC_CREATED, response.getStatus());
    }

    @Test
    public void testTransferMoneyBetweenTwoAccounts() {

    }


    @AfterClass
    public static void tearDown() throws Exception {
        client.close();
        appServer.stopServer();
    }
}
