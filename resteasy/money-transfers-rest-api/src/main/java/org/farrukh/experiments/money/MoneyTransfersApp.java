package org.farrukh.experiments.money;

import org.farrukh.experiments.money.controller.MoneyTransfersController;
import org.farrukh.experiments.money.service.AccountService;
import org.farrukh.experiments.money.service.AccountServiceImpl;
import org.farrukh.experiments.money.service.MoneyTransactionService;
import org.farrukh.experiments.money.service.MoneyTransactionServiceImpl;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class MoneyTransfersApp extends Application {

    private Set<Object> singletons;

    public MoneyTransfersApp() {
        AccountService accountService = new AccountServiceImpl();
        MoneyTransactionService transactionService = new MoneyTransactionServiceImpl(accountService);
        MoneyTransfersController moneyTransfersController = new MoneyTransfersController(accountService, transactionService);
        singletons = new HashSet<>();
        singletons.add(moneyTransfersController);
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }


}
