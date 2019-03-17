package org.farrukh.experiments.money;

import org.farrukh.experiments.money.exception.MoneyTransferException;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Client;
import org.farrukh.experiments.money.model.Transaction;
import org.farrukh.experiments.money.service.AccountServiceImpl;
import org.farrukh.experiments.money.service.MoneyTransactionService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyTransactionServiceUnitTest {

    private MoneyTransactionService moneyTransactionService;

    private AccountServiceImpl accountService;

    private int payerAccountId;

    private int recipientAccountId;

    @Before
    public void setUp() throws Exception {
        Client payer = new Client("", "");
        Client recipient = new Client("", "");
        Account payerAccount = new Account(payer, "", 200.0);
        Account recipientAccount = new Account(recipient, "", 50.0);
        payerAccountId = accountService.createAccount(payerAccount);
        recipientAccountId = accountService.createAccount(recipientAccount);
    }

    @Test
    public void testTransferMoney() throws MoneyTransferException {
        Account fromAccount = accountService.findAccountById(payerAccountId);
        Account toAccount = accountService.findAccountById(recipientAccountId);
        double amountForTransfer = 100.0;
        Transaction transaction = new Transaction(fromAccount, toAccount, amountForTransfer);
        moneyTransactionService.transfer(transaction);

        Account payer = accountService.findAccountById(payerAccountId);
        Account recipient = accountService.findAccountById(recipientAccountId);

        assertEquals(100.0, payer.getBalance(), 1);
        assertEquals(150.0, recipient.getBalance(), 1);
    }
}
