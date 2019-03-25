package org.farrukh.experiments.money.controller;

import org.farrukh.experiments.money.MainApp;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Client;
import org.farrukh.experiments.money.model.Transaction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.lang.Boolean.TRUE;
import static java.lang.String.format;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static javax.ws.rs.client.Entity.entity;
import static javax.ws.rs.core.MediaType.APPLICATION_XML_TYPE;
import static javax.ws.rs.core.UriBuilder.fromPath;
import static org.junit.Assert.assertEquals;

public class TransfersResourceIT {

    private static MainApp appServer;
    private static int port = 8181;
    private static javax.ws.rs.client.Client client;

    private MediaType acceptXmlMimeType = APPLICATION_XML_TYPE;
    private MediaType contentXmlMimType = APPLICATION_XML_TYPE;

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
        UriBuilder uriBuilder = fromPath(format("http://localhost:%s/money/accounts/create", port));
        Response response = client
                .target(uriBuilder)
                .request(acceptXmlMimeType)
                .post(entity(account, contentXmlMimType));

        assertEquals(HttpServletResponse.SC_CREATED, response.getStatus());
    }

    @Test
    public void testTransferMoneyBetweenTwoAccounts() {
        //given: accounts for money transaction.
        Account fromAccount = new Account();
        fromAccount.setBalance(100);
        fromAccount.setAccountNumber("123456789");

        Account toAccount = new Account();
        toAccount.setBalance(50);
        toAccount.setAccountNumber("987654321");

        //and: a transaction is formed.
        Transaction transaction = new Transaction();
        transaction.setDate(new Date());
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);

        transaction.setAmount(50);

        transaction.setDescription("Transfer for services");

        //when: response sent to the api
        Response response = client
                .target(fromPath(format("http://localhost:%s/money/accounts/transfer", port)))
                .request(acceptXmlMimeType)
                .put(entity(transaction, contentXmlMimType));

        //then: expected result should be returned
        Transaction transferredTransaction = response.readEntity(Transaction.class);

        assertEquals(SC_OK, response.getStatus());
        assertEquals(TRUE, transferredTransaction.isCommitted());
        assertEquals(50, transferredTransaction.getFromAccount().getBalance(), 1);
        assertEquals(100, transferredTransaction.getToAccount().getBalance(), 1);
    }

    @Test
    public void testCreateInvalidAccount() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        Client c = new Client("Ali", "Valiev");
        Account account = new Account(c, "RUR", 1_000_000_000.0);
        UriBuilder uriBuilder = fromPath(format("http://localhost:%s/money/accounts/create", port));
        Response response = client
                .target(uriBuilder)
                .request(acceptXmlMimeType)
                .post(entity(account, contentXmlMimType));

        assertEquals(HttpServletResponse.SC_CREATED, response.getStatus());
    }

    @AfterClass
    public static void tearDown() throws Exception {
        client.close();
        appServer.stopServer();
    }
}
