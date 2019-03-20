package org.farrukh.experiments.money.repository;

import org.farrukh.experiments.money.exception.MoneyTransferException;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Transaction;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryAccountDaoImpl implements AccountDao {

    private ConcurrentHashMap<Integer, Account> db = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, Transaction> txDb = new ConcurrentHashMap<>();

    private AtomicInteger idGenerator = new AtomicInteger();
    private AtomicInteger txIdGenerator = new AtomicInteger();

    @Override
    public Account createAccount(Account account) {
        return db.computeIfAbsent(idGenerator.incrementAndGet(), id -> {
            account.setId(id);
            return account;
        });
    }

    @Override
    public Account getAccountById(int accountId) {
        return db.get(accountId);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return db.values();
    }

    @Override
    public Transaction updateBalance(Transaction tx) {
        return txDb.computeIfAbsent(txIdGenerator.incrementAndGet(), id -> {
            Account fromAccount = tx.getFromAccount();
            Account toAccount = tx.getToAccount();
            double amount = tx.getAmount();
            double fund = fromAccount.getBalance() - amount;
            toAccount.setBalance(toAccount.getBalance() + fund);
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            db.put(fromAccount.getId(), fromAccount);
            db.put(toAccount.getId(), toAccount);
            return tx;
        });
    }


}
