package org.farrukh.experiments.money.service;

import org.farrukh.experiments.money.exception.MoneyTransferException;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Transaction;

public interface TransfersService {

    Transaction transfer(Transaction transaction) throws MoneyTransferException;

    Account createAccount(Account request);
}
