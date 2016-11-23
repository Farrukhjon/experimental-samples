package org.farrukh.experiments.quickfixj.client;

import java.util.concurrent.CountDownLatch;

import org.farrukh.experiments.quickfixj.client.data.MarketDataMessageHandler;
import org.farrukh.experiments.quickfixj.client.data.RefDataMessageHandler;
import org.farrukh.experiments.quickfixj.shared.FixSettingsProvider;
import org.farrukh.experiments.quickfixj.shared.exception.FixException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.ApplicationAdapter;
import quickfix.CompositeLogFactory;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FieldNotFound;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Initiator;
import quickfix.LogFactory;
import quickfix.Message;
import quickfix.RejectLogon;
import quickfix.RuntimeError;
import quickfix.SLF4JLogFactory;
import quickfix.SessionID;
import quickfix.SessionSettings;
import quickfix.SocketInitiator;

/**
 * Fix Client Engine App.
 *
 */
public class ClientApp extends ApplicationAdapter {

    private static final Logger logger = LoggerFactory.getLogger(ClientApp.class);

    private static final String CONFIG_FILE = "client.cfg";

    private final CountDownLatch shutdown_latch = new CountDownLatch(1);

    private final Initiator initiator;

    private final RefDataMessageHandler refDataMessageHandler;

    private final MarketDataMessageHandler marketDataMessageHandler;

    public ClientApp() {
        SessionSettings settings = new FixSettingsProvider().loadSettings(CONFIG_FILE);
        LogFactory logFactory = new CompositeLogFactory(new LogFactory[] { new FileLogFactory(settings), new SLF4JLogFactory(settings) });
        try {
            initiator = new SocketInitiator(this, new FileStoreFactory(settings), settings, logFactory, new DefaultMessageFactory());
        } catch (ConfigError e) {
            throw new FixException(e);
        }
        refDataMessageHandler = new RefDataMessageHandler();
        marketDataMessageHandler = new MarketDataMessageHandler();
    }

    @Override
    public void onCreate(SessionID sessionId) {
        logger.warn(sessionId.toString());
    }

    @Override
    public void toAdmin(Message message, SessionID sessionId) {
        logger.warn(message.toString());
        refDataMessageHandler.handle(message, sessionId);
    }
    
    @Override
    public void fromAdmin(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        refDataMessageHandler.handle(message, sessionId);
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

    public void stop() {
        initiator.stop();
    }

    public static void main(String[] args) {
        ClientApp clientApp = new ClientApp();
        clientApp.start();
    }

}
