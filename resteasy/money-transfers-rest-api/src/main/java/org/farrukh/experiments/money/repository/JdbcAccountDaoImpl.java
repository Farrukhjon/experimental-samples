package org.farrukh.experiments.money.repository;

import org.farrukh.experiments.money.model.Account;

import java.util.List;

public class JdbcAccountDaoImpl implements AccountDao {


    @Override
    public int createAccount(Account account) {
        return 0;
    }

    @Override
    public Account getAccountById(int accountId) {
        return null;
    }

    @Override
    public List<Account> getAllAccounts() {
        return null;
    }

    @Override
    public void updateAccounts(Account fromAccount, Account toAccount) {

    }

}
