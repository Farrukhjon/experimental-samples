package org.farrukh.experiments.money;

import org.farrukh.experiments.money.controller.TransfersController;
import org.farrukh.experiments.money.repository.InMemoryAccountDaoImpl;
import org.farrukh.experiments.money.service.TransfersService;
import org.farrukh.experiments.money.service.TransfersServiceImpl;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class MoneyTransfersApp extends Application {

    private Set<Object> singletons;

    public MoneyTransfersApp() {
        InMemoryAccountDaoImpl accountDao = new InMemoryAccountDaoImpl();
        TransfersService transactionService = new TransfersServiceImpl(accountDao);
        TransfersController transfersController = new TransfersController();
        transfersController.setTransfersService(transactionService);
        singletons = new HashSet<>();
        singletons.add(transfersController);
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }


}
