package org.farrukh.experiments.quickfixj.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.FieldNotFound;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;
import quickfix.fix50sp2.MessageCracker;
import quickfix.fix50sp2.SecurityDefinitionRequest;

public class MarketDataMessageHandler extends MessageCracker {
    
    private static final Logger logger = LoggerFactory.getLogger(MarketDataMessageHandler.class);
    
    public void handle(Message message, SessionID sessionId) {
        try {
            crack(message, sessionId);
        } catch (UnsupportedMessageType | FieldNotFound | IncorrectTagValue e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void onMessage(SecurityDefinitionRequest message, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
        logger.info("Security definition is received");
    }

}
