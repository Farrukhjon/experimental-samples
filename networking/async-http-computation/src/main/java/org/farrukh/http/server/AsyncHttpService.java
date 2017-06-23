package org.farrukh.http.server;

import org.farrukh.http.model.RequestObject;
import org.farrukh.http.model.ResponseObject;
import org.jboss.resteasy.annotations.Suspend;
import org.jboss.resteasy.spi.AsynchronousResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public interface AsyncHttpService {

    @POST
    @Path("calc")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ResponseObject calculate(RequestObject request);

    @GET
    @Path("async/calc")
    @Produces(MediaType.TEXT_PLAIN)
    void calculateAsync(@Suspend (5 * 1000) AsynchronousResponse response);


}
