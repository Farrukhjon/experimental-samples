package org.farrukh.experiments.quickfixj.client;

import org.farrukh.experiments.quickfixj.client.handler.MarketDataMessageHandler;
import org.farrukh.experiments.quickfixj.client.handler.RefDataMessageHandler;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import quickfix.FixVersions;
import quickfix.Message;
import quickfix.SessionID;
import quickfix.fixt11.Heartbeat;

@RunWith(JMockit.class)
public class ClientAppUnitTest {

    @Test
    public void shouldHandleMessageByItsSession(
            @Mocked RefDataMessageHandler refDataMsgHandler,
            @Mocked MarketDataMessageHandler marketDataMsgHandler,
            @Mocked SessionID sessionId) throws Exception {
        new Expectations() {
            {
                sessionId.getBeginString(); result = FixVersions.FIX50SP2;
            }
        };

        ClientApp sut = new ClientApp();

        Message message = new Heartbeat();
        sut.fromAdmin(message, sessionId);

        new Verifications() {
            {
                marketDataMsgHandler.handle((quickfix.fix50sp2.Message) message, sessionId); times = 1;
            }
        };
    }

}
