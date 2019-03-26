package org.farrukh.experiments.money.repository;

import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Client;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class InMemoryAccountDaoImplTest {

    private AccountDao accountDao = new InMemoryAccountDaoImpl();

    @Test
    public void testCreateAccountsByMultipleThreadsConcurrently() throws InterruptedException {
        int nWorkers = 7;
        CountDownLatch latcher = new CountDownLatch(nWorkers);
        List<Integer> createdAccountIdList = new CopyOnWriteArrayList<>();
        Runnable newAccountTask = () -> {
            Account account = new Account(new Client("Vali", "Valiev"), "RUR", 1_000_000.0);
            int accountId = accountDao.createAccount(account).getId();
            createdAccountIdList.add(accountId);
            latcher.countDown();
        };
        ExecutorService threadPool = Executors.newFixedThreadPool(nWorkers);
        for (int i = 0; i < nWorkers; i++)
            threadPool.submit(newAccountTask);
        latcher.await();
        List<Integer> expectedIds = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Collections.sort(createdAccountIdList);
        assertArrayEquals(expectedIds.toArray(), createdAccountIdList.toArray());
    }

    @Test
    public void testUpdateAccountBalance() {
        Client payer = new Client("Vali", "Valiev");
        Account newPayerAccount = new Account(payer, "RUR", 1_000_000.0);
        newPayerAccount.setId(1);

        Client recipient = new Client("Sami", "Ganiev");
        Account newRecipientAccount = new Account(recipient, "RUR", 500_000.0);
        newRecipientAccount.setId(2);

        accountDao.createAccount(newPayerAccount);
        accountDao.createAccount(newRecipientAccount);

        Account payerAccount = accountDao.findAccountById(newPayerAccount.getId());
        Account recipientAccount = accountDao.findAccountById(newRecipientAccount.getId());

        payerAccount.setBalance(payerAccount.getBalance() - 500_000.0);
        recipientAccount.setBalance(payerAccount.getBalance() + 500_000.0);

        //accountDao.updateBalance(payerAccount, recipientAccount);

        Account payerAccount1 = accountDao.findAccountById(newPayerAccount.getId());
        Account recipientAccount1 = accountDao.findAccountById(newRecipientAccount.getId());

        assertEquals(500_000.0, payerAccount1.getBalance(), 1);
        assertEquals(1_000_000.0, recipientAccount1.getBalance(), 1);
    }
}