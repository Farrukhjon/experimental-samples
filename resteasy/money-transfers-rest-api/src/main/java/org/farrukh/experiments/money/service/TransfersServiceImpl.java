package org.farrukh.experiments.money.service;

import org.farrukh.experiments.money.exception.MoneyTransferException;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Transaction;
import org.farrukh.experiments.money.repository.AccountDao;

public class TransfersServiceImpl implements TransfersService {

    private AccountDao accountDao;

    public TransfersServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Transaction transfer(Transaction transaction) throws MoneyTransferException {
        validate(transaction);
        return accountDao.updateBalance(transaction);
    }

    @Override
    public Account createAccount(Account request) {
        return accountDao.createAccount(request);
    }

    private void validate(Transaction transaction) throws MoneyTransferException {
        Account fromAccount = transaction.getFromAccount();
        Account toAccount = transaction.getToAccount();
        if (fromAccount == null || toAccount == null)
            throw new MoneyTransferException("");
    }

}
