package org.farrukh.experiments.money.service;

import org.farrukh.experiments.money.exception.MoneyTransferException;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Transaction;
import org.farrukh.experiments.money.repository.AccountDao;

import static java.lang.String.format;

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
    public Account createAccount(Account account) {
        return accountDao.createAccount(account);
    }

    @Override
    public Account getAccountById(int id) {
        return accountDao.findAccountById(id);
    }

    private void validate(Transaction transaction) throws MoneyTransferException {
        Account fromAccount = transaction.getFromAccount();
        if (transaction.getAmount() > fromAccount.getBalance())
            throw new MoneyTransferException(format("No enough money in the balance of %s account", fromAccount.getAccountNumber()));
    }

}
