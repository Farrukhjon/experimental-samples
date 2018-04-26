package org.farrukh.experiments.quickfixj.client.processor;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.Initiator;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.fix50sp2.SecurityDefinitionRequest;

public class MarketMessageProcessor {

    private static final Logger logger = LoggerFactory.getLogger(MarketMessageProcessor.class);

    public MarketMessageProcessor(Initiator initiator) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (!initiator.isLoggedOn()) {
                    logger.warn("Still logged of!");
                }
                logger.info("---------Loged on -----");
                sendSecurityDefinition(initiator);
            }

        };
        thread.start();
    }

    private void sendSecurityDefinition(Initiator initiator) {
        ArrayList<SessionID> sessions = initiator.getSessions();
        for (SessionID sessionId : sessions) {
            //if (sessionId.getBeginString().equals(FixVersions.FIX50SP2)) {
                Session.lookupSession(sessionId).send(new SecurityDefinitionRequest());
                logger.info("Client: Security definition request is sent...");
            //}
        }
    }

}
