package org.farrukh.experiments.quickfixj.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.FieldNotFound;
import quickfix.IncorrectTagValue;
import quickfix.MessageCracker;
import quickfix.SessionID;
import quickfix.UnsupportedMessageType;

public class ServerStubMsgHandler extends MessageCracker {
    
    private static final Logger logger = LoggerFactory.getLogger(ServerStubMsgHandler.class);
    
    public ServerStubMsgHandler() {
        super();
    }
    
    public void onMessage(quickfix.fixt11.Logon message, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
        logger.info("logon is colled");
    }
    
}
