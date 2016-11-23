package org.farrukh.experiments.quickfixj.client.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.FieldNotFound;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.StringField;
import quickfix.UnsupportedMessageType;
import quickfix.field.Password;
import quickfix.field.SenderCompID;
import quickfix.field.TestReqID;
import quickfix.field.Username;
import quickfix.fix50sp2.SecurityDefinitionRequest;
import quickfix.fixt11.Heartbeat;
import quickfix.fixt11.Logon;
import quickfix.fixt11.MessageCracker;
import quickfix.fixt11.TestRequest;

public class RefDataMessageHandler extends MessageCracker {

    private static final Logger logger = LoggerFactory.getLogger(RefDataMessageHandler.class);

    private static final String USER_NAME = "super_user";

    public void handle(Message message, SessionID sessionId) {
        try {
            crack(message, sessionId);
        } catch (UnsupportedMessageType | FieldNotFound | IncorrectTagValue e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onMessage(Logon message, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
        StringField senderCompId = message.getHeader().getField(new SenderCompID());
        if (senderCompId.valueEquals("CLIENT")) {
            message.setField(new Username(USER_NAME));
            message.setField(new Password("super_password"));
            logger.info("Custom Login is made");
        } else if (senderCompId.valueEquals("SERVER")) {
            sendSecDef(sessionID);
        }
    }

    private void sendSecDef(SessionID sessionID) {
        Session.lookupSession(sessionID).send(new SecurityDefinitionRequest());
    }

    public void sendTestRequest(SessionID sessionID) {
        Session.lookupSession(sessionID).send(new TestRequest());
        logger.info("Test request is made");
    }

    @Override
    public void onMessage(Heartbeat message, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
        StringField senderCompId = message.getHeader().getField(new SenderCompID());
        if (senderCompId.valueEquals("SERVER")) {
            logger.info("Test request id: {}", message.getInt(TestReqID.FIELD));
        }
    }
}
