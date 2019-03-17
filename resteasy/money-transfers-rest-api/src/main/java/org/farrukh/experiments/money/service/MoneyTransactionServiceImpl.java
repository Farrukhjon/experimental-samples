package org.farrukh.experiments.money.service;

import org.farrukh.experiments.money.exception.MoneyTransferException;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Transaction;

import static java.lang.String.format;

public class MoneyTransactionServiceImpl implements MoneyTransactionService {

    private AccountService accountService;

    public MoneyTransactionServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void transfer(Transaction transaction) throws MoneyTransferException {
        Account fromAccount = transaction.getFromAccount();
        double amount = transaction.getAmount();
        if (fromAccount.getBalance() < amount) {
            throw new MoneyTransferException(format("Insufficient amount of funds in the account [%s] to transfer", fromAccount.getAccountNumber()));
        }
        double fund = fromAccount.getBalance() - amount;
        Account toAccount = transaction.getToAccount();
        toAccount.setBalance(toAccount.getBalance() + fund);
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        accountService.updateAccounts(fromAccount, toAccount);
    }
}
