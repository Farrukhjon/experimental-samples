package org.farrukh.experiments.money.service;

import org.farrukh.experiments.money.exception.MoneyTransferException;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Transaction;

import javax.validation.constraints.NotNull;

public interface TransfersService {

    Transaction transfer(@NotNull Transaction transaction) throws MoneyTransferException;

    Account createAccount(Account account);

    Account getAccountById(int accountNumber);
}
