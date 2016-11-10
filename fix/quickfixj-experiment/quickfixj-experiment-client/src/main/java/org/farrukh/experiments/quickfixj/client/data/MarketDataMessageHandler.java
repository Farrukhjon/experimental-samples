package org.farrukh.experiments.quickfixj.client.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.FieldNotFound;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;
import quickfix.fixt11.Logon;
import quickfix.fixt11.MessageCracker;

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
    public void onMessage(Message message, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
        if (message instanceof Logon && message.isAdmin()) {
            if (((Logon) message).isSetDefaultApplVerID()) {
                //new SecDefReqMessageOutboudGateway().send(sessionID);
            }
        }
    }
    
    
    
    
    
    
    
    
    
    

}
