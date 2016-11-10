package org.farrukh.experiments.quickfixj.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.Message;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.fix50sp2.SecurityDefinitionRequest;

public class SecDefReqMessageOutboudGateway implements MessageOutboudGateway {
    
    private static final Logger logger = LoggerFactory.getLogger(SecDefReqMessageOutboudGateway.class);

    @Override
    public void send(SessionID sessionId) {
        Message message = new SecurityDefinitionRequest();
        if(Session.lookupSession(sessionId).send(message)){
            logger.info("Security definition request has been sent");
        }
    }

}
