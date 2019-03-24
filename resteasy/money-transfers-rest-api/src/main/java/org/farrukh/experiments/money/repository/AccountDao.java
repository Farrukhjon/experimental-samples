package org.farrukh.experiments.money.repository;

import org.farrukh.experiments.money.exception.MoneyTransferException;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Transaction;

import java.util.Collection;

public interface AccountDao {

    Account createAccount(Account account);

    Account findAccountById(int accountId);

    Collection<Account> getAllAccounts();

    Transaction updateBalance(Transaction transaction) throws MoneyTransferException;

}
