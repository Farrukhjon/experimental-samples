package org.farrukh.experiments.quickfixj.client;

import org.farrukh.experiments.quickfixj.client.data.MarketDataMessageHandler;
import org.farrukh.experiments.quickfixj.client.data.RefDataMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.ApplicationAdapter;
import quickfix.FieldNotFound;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.RejectLogon;
import quickfix.SessionID;

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
        refDataMsgHandler.handle(message, sessionId);
    }

    @Override
    public void fromAdmin(Message message, SessionID sessionId) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
    }


}
