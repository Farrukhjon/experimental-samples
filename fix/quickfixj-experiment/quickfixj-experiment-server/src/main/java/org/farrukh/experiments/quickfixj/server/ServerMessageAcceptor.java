package org.farrukh.experiments.quickfixj.server;

import org.farrukh.experiments.quickfixj.shared.FixSettingsProvider;
import org.farrukh.experiments.quickfixj.shared.exception.FixException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.Acceptor;
import quickfix.CompositeLogFactory;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.LogFactory;
import quickfix.MessageFactory;
import quickfix.MessageStoreFactory;
import quickfix.RuntimeError;
import quickfix.SLF4JLogFactory;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;

/**
 * Fix Engine Server App.
 *
 */
public class ServerMessageAcceptor {

    private static final Logger logger = LoggerFactory.getLogger(ServerMessageAcceptor.class);

    private static final String CONFIG_FILE = "server.cfg";

    private final Acceptor acceptor;

    public ServerMessageAcceptor() {
        try {
            SessionSettings settings = new FixSettingsProvider().loadSettings(CONFIG_FILE);
            MessageStoreFactory messageStoreFactory = new FileStoreFactory(settings);
            LogFactory logFactory = new CompositeLogFactory(
                    new LogFactory[] { new SLF4JLogFactory(settings), new FileLogFactory(settings) });
            MessageFactory messageFactory = new DefaultMessageFactory();
            acceptor = new SocketAcceptor(new ServerApp(), messageStoreFactory, settings, logFactory, messageFactory);
        } catch (ConfigError e) {
            throw new FixException(e);
        }
    }

    public void start() {
        try {
            logger.info("Server is starting...");
            acceptor.start();
        } catch (RuntimeError | ConfigError e) {
            throw new FixException(e);
        }
    }

}
