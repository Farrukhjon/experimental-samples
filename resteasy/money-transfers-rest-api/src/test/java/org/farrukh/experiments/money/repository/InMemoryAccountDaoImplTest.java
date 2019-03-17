package org.farrukh.experiments.money.repository;

import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Client;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InMemoryAccountDaoImplTest {

    AccountDao accountDao = new InMemoryAccountDaoImpl();

    @Test
    public void createAccount() {
        Client payer = new Client("Vali", "Valiev");
        Account newAccount = new Account(payer, "RUR", 1_000_000.0);
        newAccount.setId(1);
        int accountId = accountDao.createAccount(newAccount);
        assertEquals(1, accountId);
    }


    @Test
    public void updateAccounts() {
        Client payer = new Client("Vali", "Valiev");
        Account newPayerAccount = new Account(payer, "RUR", 1_000_000.0);
        newPayerAccount.setId(1);

        Client recipient = new Client("Sami", "Ganiev");
        Account newRecipientAccount = new Account(recipient, "RUR", 500_000.0);
        newRecipientAccount.setId(2);

        accountDao.createAccount(newPayerAccount);
        accountDao.createAccount(newRecipientAccount);

        Account payerAccount = accountDao.getAccountById(newPayerAccount.getId());
        Account recipientAccount = accountDao.getAccountById(newRecipientAccount.getId());

        payerAccount.setBalance(payerAccount.getBalance() - 500_000.0);
        recipientAccount.setBalance(payerAccount.getBalance() + 500_000.0);

        accountDao.updateAccounts(payerAccount, recipientAccount);

        Account payerAccount1 = accountDao.getAccountById(newPayerAccount.getId());
        Account recipientAccount1 = accountDao.getAccountById(newRecipientAccount.getId());

        Assert.assertEquals(500_000.0, payerAccount1.getBalance(), 1);
        Assert.assertEquals(1_000_000.0, recipientAccount1.getBalance(), 1);
    }
}