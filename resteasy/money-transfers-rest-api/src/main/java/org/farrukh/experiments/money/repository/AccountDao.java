package org.farrukh.experiments.money.repository;

import org.farrukh.experiments.money.exception.MoneyTransferException;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Transaction;

import java.util.List;

public interface AccountDao {

    Account createAccount(Account account);

    Account findAccountById(int accountId);

    List<Account> getAllAccounts();

    List<Account> getAllAccountsOf(int size, String sortBy);

    Transaction updateBalance(Transaction transaction) throws MoneyTransferException;

}
