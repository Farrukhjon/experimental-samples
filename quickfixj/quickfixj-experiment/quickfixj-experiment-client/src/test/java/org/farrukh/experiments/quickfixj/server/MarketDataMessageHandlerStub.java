package org.farrukh.experiments.quickfixj.server;

import java.util.List;
import java.util.UUID;

import org.farrukh.experiments.quickfixj.shared.exception.FixException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import quickfix.FieldNotFound;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.SessionNotFound;
import quickfix.UnsupportedMessageType;
import quickfix.field.SecurityReqID;
import quickfix.field.SecurityResponseID;
import quickfix.fix50sp2.MessageCracker;
import quickfix.fix50sp2.SecurityDefinition;
import quickfix.fix50sp2.SecurityDefinitionRequest;
import quickfix.fix50sp2.TradeCaptureReport;
import quickfix.fix50sp2.TradeCaptureReportRequest;

public class MarketDataMessageHandlerStub extends MessageCracker {

    private static final Logger logger = LoggerFactory.getLogger(MarketDataMessageHandlerStub.class);
    
    private final List<SecurityDefinition> securityDefinitions;

    private final List<TradeCaptureReport> tradeCaptureReports;
    
    public MarketDataMessageHandlerStub() {
        InMemoryMarketDataProviderStub inMemoryMarketDataProviderStub = new InMemoryMarketDataProviderStub();
        securityDefinitions = inMemoryMarketDataProviderStub.getSecurityDefinitions();
        tradeCaptureReports = inMemoryMarketDataProviderStub.getTradeCaptureReports();
    }
    
    public void handle(Message message, SessionID sessionId) {
        try {
            crack(message, sessionId);
        } catch (UnsupportedMessageType | FieldNotFound | IncorrectTagValue e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public void onMessage(SecurityDefinitionRequest messageRequest, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
        logger.info("Server: Security definition request is received");
        try {
            String secReqId = messageRequest.getString(SecurityReqID.FIELD);
            for (SecurityDefinition securityDefinition : securityDefinitions) {
                enrich(secReqId, securityDefinition);
                Session.sendToTarget(securityDefinition, sessionID);
                logger.info("Server: The security definition {} response is sent", securityDefinition);
            }
        } catch (SessionNotFound e) {
            throw new FixException(e);
        }
    }
    
    @Override
    public void onMessage(TradeCaptureReportRequest messageRequest, SessionID sessionID) throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
        for (TradeCaptureReport tradeCaptureReport : tradeCaptureReports) {
            try {
                Session.sendToTarget(tradeCaptureReport, sessionID);
                logger.info("Server: The trade capture report {} is sent", tradeCaptureReport);
            } catch (SessionNotFound e) {
                throw new FixException(e);
            }
        }
    }

    private void enrich(String secReqId, SecurityDefinition securityDefinition) {
        securityDefinition.set(new SecurityReqID(secReqId));
        securityDefinition.set(new SecurityResponseID(UUID.randomUUID().toString()));
    }

}
