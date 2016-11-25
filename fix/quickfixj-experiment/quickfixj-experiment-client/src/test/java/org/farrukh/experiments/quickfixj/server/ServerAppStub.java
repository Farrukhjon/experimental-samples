package org.farrukh.experiments.quickfixj.server;

import org.farrukh.experiments.quickfixj.shared.FixSettingsProvider;
import org.farrukh.experiments.quickfixj.shared.exception.FixException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.Acceptor;
import quickfix.ApplicationAdapter;
import quickfix.CompositeLogFactory;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FieldNotFound;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.FixVersions;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.LogFactory;
import quickfix.Message;
import quickfix.MessageStoreFactory;
import quickfix.RuntimeError;
import quickfix.SLF4JLogFactory;
import quickfix.SessionID;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;
import quickfix.UnsupportedMessageType;

public class ServerAppStub extends ApplicationAdapter {
    
    private static final Logger logger = LoggerFactory.getLogger(ServerAppStub.class);

    private static final String CONFIG_FILE = "server.cfg";

    private final Acceptor acceptor;
    
    private RefDataMessageHandlerStub refDataMsgHandler;
    
    private MarketDataMessageHandlerStub marketDataMsgHandler;
    
    public ServerAppStub() {
        try {
            SessionSettings settings = new FixSettingsProvider().loadSettings(CONFIG_FILE);
            MessageStoreFactory messageStoreFactory = new FileStoreFactory(settings);
            LogFactory logFactory = new CompositeLogFactory(new LogFactory[]{new SLF4JLogFactory(settings), new FileLogFactory(settings)});
            DefaultMessageFactory messageFactory = new DefaultMessageFactory();
            messageFactory.addFactory(FixVersions.FIX50, quickfix.fix50sp2.MessageFactory.class);
            acceptor = new SocketAcceptor(this, messageStoreFactory, settings, logFactory, messageFactory);
            refDataMsgHandler = new RefDataMessageHandlerStub();
            marketDataMsgHandler = new MarketDataMessageHandlerStub();
        } catch (ConfigError e) {
            throw new FixException(e);
        }
    }
    
    public void start() {
        try {
            acceptor.start();
            logger.info("The Server Stub is started");
        } catch (RuntimeError | ConfigError e) {
            throw new FixException(e);
        }
    }
    
    public void stop() {
        try {
            acceptor.stop();
            logger.info("The Server Stub is stoped");
        } catch (RuntimeError e) {
            throw new FixException(e);
        }
    }
    
    @Override
    public void fromAdmin(Message message, SessionID sessionId) {
          refDataMsgHandler.handle(message, sessionId);
          logger.info("From admin: Message: {}, session: {}", message, sessionId);
    }
    
    @Override
    public void toAdmin(Message message, SessionID sessionId) {
        logger.info("To admin: Message: {}, session: {}", message, sessionId);
    }
    
    @Override
    public void fromApp(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        marketDataMsgHandler.handle(message, sessionId);
    }


}
