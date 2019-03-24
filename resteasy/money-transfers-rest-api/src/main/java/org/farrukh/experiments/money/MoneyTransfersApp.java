package org.farrukh.experiments.money;

import org.farrukh.experiments.money.controller.TransfersResource;
import org.farrukh.experiments.money.providers.MoneyTransferExceptionMapper;
import org.farrukh.experiments.money.repository.InMemoryAccountDaoImpl;
import org.farrukh.experiments.money.service.TransfersService;
import org.farrukh.experiments.money.service.TransfersServiceImpl;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/money")
public class MoneyTransfersApp extends Application {

    private Set<Object> singletons;

    public MoneyTransfersApp() {
        InMemoryAccountDaoImpl accountDao = new InMemoryAccountDaoImpl();
        TransfersService transactionService = new TransfersServiceImpl(accountDao);
        TransfersResource transfersResource = new TransfersResource();
        transfersResource.setTransfersService(transactionService);
        singletons = new HashSet<>();
        singletons.add(transfersResource);
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(MoneyTransferExceptionMapper.class);
        return classes;
    }
}
