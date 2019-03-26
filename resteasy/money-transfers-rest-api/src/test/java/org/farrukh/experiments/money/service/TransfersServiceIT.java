package org.farrukh.experiments.money.service;

import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Client;
import org.farrukh.experiments.money.repository.InMemoryAccountDaoImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransfersServiceIT {

    private TransfersService transfersService;

    public TransfersServiceIT() {
        transfersService = new TransfersServiceImpl(new InMemoryAccountDaoImpl());
    }

    @Test
    public void testCreateNewAccountInDbHappyPath() {
        //given: a new submitted account.
        Account account = new Account();
        account.setAccountNumber("123456789");
        account.setBalance(100d);
        account.setCurrency("RUR");
        account.setClient(new Client("Ali", "Valiev"));

        //when: create method of the service is called.
        Account resultAccount = transfersService.createAccount(account);

        //then: expected result should be returned.
        assertEquals(1, resultAccount.getId());
    }

    @Test
    public void testCreateNewAccountInDbSaidPath() {
        transfersService.createAccount(null);
    }

}
