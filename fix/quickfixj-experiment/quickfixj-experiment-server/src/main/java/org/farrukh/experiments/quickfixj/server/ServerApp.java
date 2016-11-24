package org.farrukh.experiments.quickfixj.server;

import org.farrukh.experiments.quickfixj.server.handler.MarketDataMessageHandler;
import org.farrukh.experiments.quickfixj.server.handler.RefDataMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.ApplicationAdapter;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;

/**
 * Fix Engine Server App.
 *
 */
public class ServerApp extends ApplicationAdapter {

    private static final Logger logger = LoggerFactory.getLogger(ServerApp.class);

    private final RefDataMessageHandler refDataMsgHandler;

    private final MarketDataMessageHandler marketDataMsgHandler;

    public ServerApp() {
        refDataMsgHandler = new RefDataMessageHandler();
        marketDataMsgHandler = new MarketDataMessageHandler();
    }

    @Override
    public void toAdmin(Message message, SessionID sessionId) {
        handle(message, sessionId);
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionId) {
        handle(message, sessionId);
    }
    
    @Override
    public void fromApp(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        marketDataMsgHandler.handle(message, sessionId);
    }
    

    private void handle(Message message, SessionID sessionId) {
        if (sessionId.isFIXT()) {
            refDataMsgHandler.handle(message, sessionId);
        }
    }

}
