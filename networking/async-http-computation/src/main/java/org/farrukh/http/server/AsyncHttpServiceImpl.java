package org.farrukh.http.server;

import org.farrukh.http.model.RequestObject;
import org.farrukh.http.model.ResponseObject;
import org.jboss.resteasy.annotations.Suspend;
import org.jboss.resteasy.spi.AsynchronousResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by fsattorov on 22.06.2017.
 */
@Path("/")
public class AsyncHttpServiceImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncHttpServiceImpl.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void calculateAsync(@Suspended AsyncResponse response) {
        new Thread(new CalculateTask(response)).
                start();
    }

    private class CalculateTask implements Runnable {

        private final AsyncResponse response;

        public CalculateTask(AsyncResponse response) {
            this.response = response;
        }

        public void run() {
            try {
                LOGGER.info("Calculating...");
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Response resp = Response.
                    ok(new ResponseObject("Calculation result")).
                    build();
            LOGGER.info("Completing long processing calculation...");
            response.resume(resp);
        }

    }
}
