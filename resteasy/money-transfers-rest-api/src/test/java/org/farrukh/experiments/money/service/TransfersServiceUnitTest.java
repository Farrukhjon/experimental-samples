package org.farrukh.experiments.money.service;

import org.farrukh.experiments.money.BaseUnitTest;
import org.farrukh.experiments.money.MainApp;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.repository.AccountDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class TransfersServiceUnitTest extends BaseUnitTest {

    @Mock
    private AccountDao accountDao;

    @InjectMocks
    private TransfersServiceImpl transfersService;

    @Before
    public void setUp() throws Exception {
        assertNotNull(accountDao);
        assertNotNull(transfersService);
    }

    @Test
    public void testCreateNewAccount() {
        //given: a submitted account detail.
        Account accountDetail = new Account();


        when(accountDao.createAccount(accountDetail)).thenReturn(accountDetail);

        //when:
        Account newAccount = transfersService.createAccount(accountDetail);

        //then:
        assertNotNull(newAccount);
    }
}
