package org.farrukh.experiments.money.service;

import org.farrukh.experiments.money.exception.MoneyTransferException;
import org.farrukh.experiments.money.model.Transaction;

public interface MoneyTransactionService {

    void transfer(Transaction transaction) throws MoneyTransferException;

}
