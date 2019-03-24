package org.farrukh.experiments.money.repository;

import org.farrukh.experiments.money.exception.MoneyTransferException;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Transaction;

import java.util.Collection;

public class JdbcAccountDaoImpl implements AccountDao {

    @Override
    public Account createAccount(Account account) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Account findAccountById(int accountId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Account> getAllAccounts() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Transaction updateBalance(Transaction transaction) throws MoneyTransferException {
        throw new UnsupportedOperationException();
    }

}
