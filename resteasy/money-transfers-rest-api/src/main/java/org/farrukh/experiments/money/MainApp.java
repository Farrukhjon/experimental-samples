package org.farrukh.experiments.money;

import io.undertow.Undertow;
import io.undertow.servlet.api.DeploymentInfo;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

public class MainApp {

    private static final String CONTEXT_ROOT_PATH = "/";

    private final UndertowJaxrsServer server;
    private final Undertow.Builder builder;

    public MainApp(int port, String host) throws Exception {
        builder = Undertow
                .builder()
                .addHttpListener(port, host);
        server = new UndertowJaxrsServer();
        DeploymentInfo di = server.undertowDeployment(MoneyTransfersApp.class);
        di.addDeploymentCompleteListener(new ResteasyBootstrap());
        di.setContextPath(CONTEXT_ROOT_PATH);
        di.setDeploymentName("Resteasy");
        server.deploy(di);
    }

    public static void main(String[] args) throws Exception {
        CommandLine cmd = parseAndGetCli(args);
        int port = Integer.parseInt(cmd.getOptionValue("p", "8080"));
        String hostname = cmd.getOptionValue("n", "localhost");
        MainApp app = new MainApp(port, hostname);
        app.startServer();

    }

    private static CommandLine parseAndGetCli(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption("p", "port", true, "port number");
        options.addOption("n", "hostname", true, "hostname, e.g. localhost");
        return new DefaultParser().parse(options, args);
    }

    public void startServer() throws Exception {
        try {
            server.start(builder);
        } catch (Exception e) {
            throw e;

        }
    }

    public void stopServer() throws Exception {
        try {
            server.stop();
        } catch (Exception e) {
            throw e;
        }
    }

}
