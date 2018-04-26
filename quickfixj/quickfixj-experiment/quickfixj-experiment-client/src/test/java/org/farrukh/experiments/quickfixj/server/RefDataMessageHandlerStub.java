package org.farrukh.experiments.quickfixj.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.FieldNotFound;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.SessionNotFound;
import quickfix.UnsupportedMessageType;
import quickfix.field.Username;
import quickfix.fixt11.Logon;
import quickfix.fixt11.MessageCracker;
import quickfix.fixt11.Reject;

public class RefDataMessageHandlerStub extends MessageCracker {
    
    private static final Logger logger = LoggerFactory.getLogger(RefDataMessageHandlerStub.class);
    
    public void handle(Message message, SessionID sessionId) {
        try {
            crack(message, sessionId);
        } catch (UnsupportedMessageType | FieldNotFound | IncorrectTagValue e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void onMessage(Logon message, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
        logger.info("Logon message is come to the msg handler: {}", message);
        Username userName = new Username();
        message.get(userName);
        if(!userName.valueEquals("root")) {
            logger.info("Username is not set: {}", userName.getValue());
            try {
                Session.sendToTarget(new Reject(), sessionID);
                logger.info("REJECTED!");
            } catch (SessionNotFound e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}
