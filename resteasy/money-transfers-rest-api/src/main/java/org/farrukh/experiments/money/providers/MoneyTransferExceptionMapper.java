package org.farrukh.experiments.money.providers;

import org.farrukh.experiments.money.exception.MoneyTransferException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MoneyTransferExceptionMapper implements ExceptionMapper<MoneyTransferException> {

    @Override
    public Response toResponse(MoneyTransferException exception) {
        return Response
                .noContent()
                .build();
    }

}
