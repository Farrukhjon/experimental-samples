package org.farrukh.experiments.quickfixj.client;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import org.farrukh.experiments.quickfixj.client.processor.MarketMessageProcessor;
import org.farrukh.experiments.quickfixj.shared.FixSettingsProvider;
import org.farrukh.experiments.quickfixj.shared.exception.FixException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.CompositeLogFactory;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.FixVersions;
import quickfix.Initiator;
import quickfix.LogFactory;
import quickfix.RuntimeError;
import quickfix.SLF4JLogFactory;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.SessionSettings;
import quickfix.SocketInitiator;
import quickfix.fixt11.Logout;

public final class ClientMessageConnector {

    public static final Logger logger = LoggerFactory.getLogger(ClientMessageConnector.class);

    public static final String CONFIG_FILE = "client.cfg";

    public final CountDownLatch shutdown_latch = new CountDownLatch(1);

    private final Initiator initiator;

    public ClientMessageConnector() {
        ClientApp clientApp = new ClientApp();
        SessionSettings settings = new FixSettingsProvider().loadSettings(CONFIG_FILE);
        LogFactory logFactory = new CompositeLogFactory(new LogFactory[] { new FileLogFactory(settings), new SLF4JLogFactory(settings) });
        final DefaultMessageFactory defaultMessageFactory = new DefaultMessageFactory();
        defaultMessageFactory.addFactory(FixVersions.FIX50, quickfix.fix50sp2.MessageFactory.class);
        try {
            initiator = new SocketInitiator(clientApp, new FileStoreFactory(settings), settings, logFactory, defaultMessageFactory);
            new MarketMessageProcessor(initiator);
        } catch (ConfigError e) {
            throw new FixException(e);
        }
    }

    public void start() {
        try {
            initiator.start();
            logger.info("The Client is started");
            shutdown_latch.await();
        } catch (RuntimeError | ConfigError e) {
            throw new FixException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void sendLogoff() {
        if (initiator.isLoggedOn()) {
            ArrayList<SessionID> sessions = initiator.getSessions();
            for (SessionID sessionID : sessions) {
                if (sessionID.getBeginString().equals("FIXT.1.1")) {
                    Session.lookupSession(sessionID).send(new Logout());
                    logger.info("Logout message is sent");
                }
            }
        }
    }

    public void stop() {
        shutdown_latch.countDown();
        logger.info("Count down is invoked so that shutding down is called");
    }

}
