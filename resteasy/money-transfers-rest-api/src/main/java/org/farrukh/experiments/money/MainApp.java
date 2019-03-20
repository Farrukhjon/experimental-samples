package org.farrukh.experiments.money;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

import static org.jboss.resteasy.plugins.server.servlet.ResteasyContextParameters.RESTEASY_SERVLET_MAPPING_PREFIX;

public class MainApp {

    private static final String CONTEXT_ROOT_PATH = "/";
    private static final String API_PATH = "/money";

    private Server server;

    public MainApp(int port) {
        server = new Server(8181);
        ServletContextHandler servletContext = new ServletContextHandler(server, CONTEXT_ROOT_PATH);
        ServletHolder apiServlet = new ServletHolder(new HttpServletDispatcher());
        apiServlet.setInitParameter(RESTEASY_SERVLET_MAPPING_PREFIX, API_PATH);
        apiServlet.setInitParameter("javax.ws.rs.Application", "org.farrukh.experiments.money.MoneyTransfersApp");
        servletContext.addServlet(apiServlet, API_PATH + "/*");
        servletContext.addServlet(new ServletHolder(new DefaultServlet()), CONTEXT_ROOT_PATH);
        server.setStopAtShutdown(Boolean.TRUE);
    }

    public static void main(String[] args) throws Exception {
        MainApp app = new MainApp(8181);
        app.startServer();
    }

    public void startServer() throws Exception {
        try {
            server.start();
        } catch (Exception e) {
            throw e;

        }
    }

    public void stopServer() throws Exception {
        try {
            server.stop();
            server.destroy();
        } catch (Exception e) {
            throw e;
        }
    }

}
