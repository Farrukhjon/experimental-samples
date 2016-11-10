package org.farrukh.experiments.quickfixj.client;

import java.util.concurrent.CountDownLatch;

import org.farrukh.experiments.quickfixj.shared.FixSettingsProvider;
import org.farrukh.experiments.quickfixj.shared.exception.FixException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.ApplicationAdapter;
import quickfix.CompositeLogFactory;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.LogFactory;
import quickfix.Message;
import quickfix.RejectLogon;
import quickfix.RuntimeError;
import quickfix.SLF4JLogFactory;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.SessionSettings;
import quickfix.SocketInitiator;
import quickfix.fixt11.Logon;

/**
 * Fix Client Engine App.
 *
 */
public class ClientApp extends ApplicationAdapter {
    
    private static final Logger logger = LoggerFactory.getLogger(ClientApp.class);
    
    private static final String CONFIG_FILE = "client.cfg";

    private static final CountDownLatch shutdown_latch = new CountDownLatch(1);
    
    private final SocketInitiator initiator;
    
    private final MessageHandler messageHandler;

    public ClientApp() {
        SessionSettings settings = new FixSettingsProvider().loadSettings(CONFIG_FILE);
        LogFactory logFactory = new CompositeLogFactory(new LogFactory[] { new FileLogFactory(settings), new SLF4JLogFactory(settings) });
        try {
            initiator = new SocketInitiator(this, new FileStoreFactory(settings), settings, logFactory, new DefaultMessageFactory());
        } catch (ConfigError e) {
            throw new FixException(e);
        }
        messageHandler = new MessageHandler();
    }
    
    @Override
    public void onCreate(SessionID sessionId) {
        if ("FIXT.1.1".equals(sessionId.getBeginString())) {
            Session.lookupSession(sessionId);
        }
    }
    
    @Override
    public void fromAdmin(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        if ("FIXT.1.1".equals(sessionId.getBeginString())) {
            messageHandler.handle(message, sessionId);
        }
    }

    @Override
    public void toApp(Message message, SessionID sessionId) throws DoNotSend {
        messageHandler.handle(message, sessionId);
    }

    private void start() {
        try {
            initiator.start();
        } catch (RuntimeError | ConfigError e) {
            throw new FixException(e);
        }
    }

    public static void main(String[] args) {
        ClientApp clientApp = new ClientApp();
        clientApp.start();
        try {
            shutdown_latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
