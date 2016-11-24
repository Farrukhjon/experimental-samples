package org.farrukh.experiments.quickfixj.server;

import org.farrukh.experiments.quickfixj.server.handler.MarketDataMessageHandler;
import org.farrukh.experiments.quickfixj.server.handler.RefDataMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.ApplicationAdapter;
import quickfix.FixVersions;
import quickfix.Message;
import quickfix.SessionID;

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

    private void handle(Message message, SessionID sessionId) {
        if (sessionId.isFIXT()) {
            refDataMsgHandler.handle(message, sessionId);
        } else if (sessionId.getBeginString().equals(FixVersions.FIX50SP2)) {
            marketDataMsgHandler.handle(message, sessionId);
        }
    }

}
