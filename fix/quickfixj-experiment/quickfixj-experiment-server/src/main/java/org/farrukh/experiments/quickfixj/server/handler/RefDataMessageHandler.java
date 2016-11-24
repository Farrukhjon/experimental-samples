package org.farrukh.experiments.quickfixj.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.FieldNotFound;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;
import quickfix.fixt11.Logon;
import quickfix.fixt11.MessageCracker;

public class RefDataMessageHandler extends MessageCracker {

    private static final Logger logger = LoggerFactory.getLogger(RefDataMessageHandler.class);

    public void handle(Message message, SessionID sessionId) {
        try {
            crack(message, sessionId);
        } catch (UnsupportedMessageType | FieldNotFound | IncorrectTagValue e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void onMessage(Logon message, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
        logger.info("This logon message has been received via session: {} and message: {}", sessionID, message.toString());
    }

  
}
