package org.farrukh.experiments.money.service;

import org.farrukh.experiments.money.exception.MoneyTransferException;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Transaction;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface TransfersService {

    Transaction transfer(@NotNull Transaction transaction) throws MoneyTransferException;

    Account createAccount(Account account);

    Account getAccountById(int accountNumber);

    List<Account> findAccountsOf(int size, String sortedBy);
}
