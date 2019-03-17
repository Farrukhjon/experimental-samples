package org.farrukh.experiments.money.repository;

import org.farrukh.experiments.money.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryAccountDaoImpl implements AccountDao {

    private ConcurrentHashMap<Integer, Account> db = new ConcurrentHashMap<>();

    @Override
    public int createAccount(Account account) {
        db.putIfAbsent(account.getId(), account);
        return account.getId();
    }

    @Override
    public Account getAccountById(int accountId) {
        return db.get(accountId);
    }

    @Override
    public List<Account> getAllAccounts() {
        return new ArrayList<>(db.values());
    }

    @Override
    public void updateAccounts(Account fromAccount, Account toAccount) {
        db.putIfAbsent(fromAccount.getId(), fromAccount);
        db.putIfAbsent(toAccount.getId(), toAccount);
    }

}
