package org.farrukh.experiments.quickfixj.client;

import org.farrukh.experiments.quickfixj.client.handler.MarketDataMessageHandler;
import org.farrukh.experiments.quickfixj.client.handler.RefDataMessageHandler;
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
 * Fix Client Engine App.
 *
 */
public class ClientApp extends ApplicationAdapter {

    public static final Logger logger = LoggerFactory.getLogger(ClientApp.class);

    private final RefDataMessageHandler refDataMsgHandler;

    private final MarketDataMessageHandler marketDataMsgHandler;

    public ClientApp() {
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
        if (sessionId.isFIXT())
            refDataMsgHandler.handle(message, sessionId);
    }

}
