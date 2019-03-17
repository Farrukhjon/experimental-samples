package org.farrukh.experiments.money.service;

import org.farrukh.experiments.money.model.Account;

public interface AccountService {
    void updateAccounts(Account fromAccount, Account toAccount);

    int createAccount(Account request);
}
