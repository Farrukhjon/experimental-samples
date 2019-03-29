package org.farrukh.experiments.money.repository;

import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Transaction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.Boolean.TRUE;
import static java.util.Comparator.comparing;

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
    public Account findAccountById(int accountId) {
        return db.get(accountId);
    }

    @Override
    public List<Account> getAllAccounts() {
        return new ArrayList<>(db.values());
    }

    @Override
    public List<Account> getAllAccountsOf(int size, String sortBy) {
        return db
                .values()
                .stream()
                .limit(size)
                .sorted(mapComparator(sortBy))
                .collect(Collectors.toList());
    }

    private Comparator<? super Account> mapComparator(String sortBy) {
        switch (sortBy) {
            case "id":
                return comparing(Account::getId);
            case "clientName":
                return comparing(a -> a.getClient().getFirstName());
            default:
                return comparing(Account::getAccountNumber);
        }
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
            tx.setCommitted(TRUE);
            return tx;
        });
    }


}
