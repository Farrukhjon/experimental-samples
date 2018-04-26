package org.farrukh.experiments.quickfixj.server;

import org.farrukh.experiments.quickfixj.client.ClientStub;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServerMessageAcceptorIntegrationTest {

    ServerMessageAcceptor serverAcceptor = new ServerMessageAcceptor();
    private ClientStub client;

    @Before
    public void setup() {
        serverAcceptor.start();
        client = new ClientStub();
    }

    @Test
    public void testApp() {
        client.sendLogon();
    }

    @After
    public void tearDown() {
        serverAcceptor.stop();
        client.stop();
    }
}
