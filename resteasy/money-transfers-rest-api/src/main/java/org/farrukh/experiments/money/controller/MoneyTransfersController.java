package org.farrukh.experiments.money.controller;

import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.service.AccountService;
import org.farrukh.experiments.money.service.MoneyTransactionService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("/account")
public class MoneyTransfersController {

    private AccountService accountService;

    private MoneyTransactionService moneyTransactionService;

    public MoneyTransfersController(AccountService accountService, MoneyTransactionService moneyTransactionService) {
        this.accountService = accountService;
        this.moneyTransactionService = moneyTransactionService;

    }

    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAccount(Account request, @Context UriInfo uriInfo) {
        int accountId = accountService.createAccount(request);
        URI location = uriInfo
                .getAbsolutePathBuilder()
                .path(Integer.toString(accountId))
                .build();
        return Response
                .created(location)
                .build();
    }

}
