package org.farrukh.experiments.quickfixj.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.FieldNotFound;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.MessageCracker;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;

public class ServerStubMsgHandler extends MessageCracker {
    
    private static final Logger logger = LoggerFactory.getLogger(ServerStubMsgHandler.class);
    
    public ServerStubMsgHandler() {
        super();
    }
    
    public void handle(Message message, SessionID sessionId) {
        try {
            crack(message, sessionId);
        } catch (UnsupportedMessageType | FieldNotFound | IncorrectTagValue e) {
            throw new RuntimeException(e);
        }
    }
    
    public void onMessage(Message message, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
   /*     if(!message.isSetField(Username.FIELD) || !message.isSetField(Password.FIELD)) {
            Session.lookupSession(sessionID).send(new Reject());
            logger.info("Logon has been rejected");
        }*/
        logger.info("Logon message is come to the msg handler: {}", message);
    }
    
}
