package org.farrukh.http.server;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServlet30Dispatcher;

import static org.eclipse.jetty.servlet.ServletContextHandler.NO_SESSIONS;

/**
 * Created by fsattorov on 22.06.2017.
 */
public class HttpJettyServer {

    private static final int PORT = 8989;


    public HttpJettyServer() {
        try {

            Server server = new Server();

            HandlerList handlerList = new HandlerList();

            ServletContextHandler servletContextHandler = new ServletContextHandler(NO_SESSIONS);

            servletContextHandler.setContextPath("/");

            ServletHolder servletHolder = new ServletHolder(new HttpServlet30Dispatcher());

            servletContextHandler.addServlet(servletHolder, "/*");

            servletContextHandler.setInitParameter("resteasy.servlet.mapping.prefix", "/async");
            servletContextHandler.setInitParameter("resteasy.use.builtin.providers", "true");
            servletContextHandler.setInitParameter("javax.ws.rs.Application", "org.farrukh.http.CalculatorApp");

            handlerList.addHandler(servletContextHandler);

            server.setHandler(handlerList);

            SelectChannelConnector connector = new SelectChannelConnector();
            connector.setPort(PORT);
            server.addConnector(connector);

            server.start();
            server.join();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
