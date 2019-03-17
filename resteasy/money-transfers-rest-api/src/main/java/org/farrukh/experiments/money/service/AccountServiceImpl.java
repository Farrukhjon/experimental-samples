package org.farrukh.experiments.money.service;

import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.repository.AccountDao;
import org.farrukh.experiments.money.repository.InMemoryAccountDaoImpl;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public AccountServiceImpl() {
        accountDao = new InMemoryAccountDaoImpl();
    }

    public Account findAccountById(int accountId) {
        return accountDao.getAccountById(accountId);
    }

    public List<Account> findAllAccounts() {
        return accountDao.getAllAccounts();
    }

    @Override
    public void updateAccounts(Account fromAccount, Account toAccount) {

    }

    public int createAccount(Account payerAccount) {
        return 0;
    }
}
