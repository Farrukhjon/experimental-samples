package org.farrukh.experiments.money.controller;

import org.farrukh.experiments.money.service.MoneyTransactionService;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletResponse;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class MoneyTransfersControllerUnitTest {

    private static Dispatcher dispatcher;
    private MoneyTransfersController moneyTransfersController;
    private static MoneyTransactionService mtService;

    @BeforeClass
    public static void initMockService() throws Exception {
        dispatcher = MockDispatcherFactory.createDispatcher();
        mtService = Mockito.mock(MoneyTransactionService.class);

    }

    @Test
    public void testTransferringMoneyBetweenTwoAccounts() throws URISyntaxException {
        MockHttpRequest createAccountRequest = MockHttpRequest.create("", "");
        MockHttpResponse response = new MockHttpResponse();
        dispatcher.invoke(createAccountRequest, response);

        int responseStatusCode = response.getStatus();
        assertEquals(HttpServletResponse.SC_CREATED, responseStatusCode);
    }
}