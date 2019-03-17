package org.farrukh.experiments.money.repository;

import org.farrukh.experiments.money.model.Account;

import java.util.List;

public interface AccountDao {

    int createAccount(Account account);

    Account getAccountById(int accountId);

    List<Account> getAllAccounts();

    void updateAccounts(Account fromAccount, Account toAccount);
}
