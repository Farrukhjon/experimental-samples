package org.farrukh.experiments.money.controller;

import org.farrukh.experiments.money.exception.MoneyTransferException;
import org.farrukh.experiments.money.model.Account;
import org.farrukh.experiments.money.model.Transaction;
import org.farrukh.experiments.money.service.TransfersService;
import org.jboss.resteasy.links.AddLinks;
import org.jboss.resteasy.links.LinkResource;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

import static java.lang.String.format;

@Path("/")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class TransfersResource {

    private TransfersService transfersService;

    @GET
    @Path("/accounts/{id}")
    public Account getAccount(@PathParam("id") int id) throws MoneyTransferException {
        Account account = transfersService.getAccountById(id);
        if (account != null)
            return account;
        throw new MoneyTransferException(format("Account by %s id not found", id));
    }

    @AddLinks
    @LinkResource(Account.class)
    @POST
    @Path("/accounts/create")
    public Response createAccount(@Valid Account request, @Context UriInfo uriInfo) {
        Account newAccount = transfersService.createAccount(request);
        URI location = uriInfo
                .getAbsolutePathBuilder()
                .path(Integer.toString(newAccount.getId()))
                .build();
        return Response
                .created(location)
                .entity(newAccount)
                .build();
    }

    @PUT
    @Path("/accounts/transfer")
    public Response transfer(@Valid Transaction tx) throws MoneyTransferException {
        try {
            Transaction transfer = transfersService.transfer(tx);
            return Response
                    .ok()
                    .entity(transfer)
                    .build();
        } catch (MoneyTransferException e) {
            throw new MoneyTransferException("Error");
        }
    }

    @GET
    @Path("/accounts")
    public List<Account> getAllAccounts(@QueryParam("size") int size, @QueryParam("sortedBy") String sortedBy) {
        return transfersService.findAccountsOf(size, sortedBy);
    }

    public TransfersService getTransfersService() {
        return transfersService;
    }

    public void setTransfersService(TransfersService transfersService) {
        this.transfersService = transfersService;
    }


}
