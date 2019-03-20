package org.farrukh.experiments.money.controller;

import org.farrukh.experiments.money.BaseUnitTest;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Client;
import org.farrukh.experiments.money.model.Transaction;
import org.farrukh.experiments.money.repository.AccountDao;
import org.farrukh.experiments.money.service.TransfersService;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static javax.ws.rs.core.MediaType.APPLICATION_XML_TYPE;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TransfersControllerUnitTest extends BaseUnitTest {

    @Mock
    private TransfersService transfersService;

    @InjectMocks
    private TransfersController transfersController;

    private Dispatcher dispatcher;

    @Before
    public void initMockService() {
        dispatcher = MockDispatcherFactory.createDispatcher();
        dispatcher.getRegistry().addSingletonResource(transfersController);
    }

    @Test
    public void testCreateNewAccount() throws Exception {
        Account newAcc = new Account();
        newAcc.setId(1);
        when(transfersService.createAccount(Mockito.any()))
                .thenReturn(newAcc);
        Client client = new Client("Ali", "Valiev");
        Account account = new Account(client, "RUR", 1_000_000_000.0);
        String strXml = convertToStrXml(account, Account.class);
        MockHttpRequest createAccountRequest = MockHttpRequest
                .post("/accounts/create")
                .content(strXml.getBytes())
                .contentType(APPLICATION_XML_TYPE)
                .accept(APPLICATION_XML_TYPE);
        MockHttpResponse response = new MockHttpResponse();
        dispatcher.invoke(createAccountRequest, response);
        int responseStatusCode = response.getStatus();
        String contentAsString = response.getContentAsString();
        Account newAccount = convertStrXmlToEntity(contentAsString, Account.class);
        assertEquals(1, newAccount.getId());
        assertEquals(HttpServletResponse.SC_CREATED, responseStatusCode);
    }

    @Test
    public void testTransferMoneyBetweenTwoAccounts() throws Exception {
        String url = "/accounts/transfer";
        Transaction newTx = new Transaction();
        newTx.setAmount(1000);
        newTx.setFromAccount(new Account());
        newTx.setToAccount(new Account());
        newTx.setDate(new Date());
        newTx.setDescription("Blah Blah Blah");

        MockHttpResponse response = new MockHttpResponse();
        Transaction committedTx = new Transaction();
        committedTx.setId(1);
        committedTx.setCommitted(true);
        when(transfersService.transfer(Mockito.any())).thenReturn(committedTx);

        String str = convertToStrXml(newTx, Transaction.class);
        MockHttpRequest request = MockHttpRequest
                .put(url)
                .content(str.getBytes())
                .contentType(APPLICATION_XML_TYPE)
                .accept(APPLICATION_XML_TYPE);
        dispatcher.invoke(request, response);

        String contentAsString = response.getContentAsString();
        Transaction transaction = convertStrXmlToEntity(contentAsString, Transaction.class);

        assertEquals(HttpServletResponse.SC_OK, response.getStatus());

        assertEquals(1, transaction.getId());
        assertEquals(Boolean.TRUE, transaction.isCommitted());
    }


}