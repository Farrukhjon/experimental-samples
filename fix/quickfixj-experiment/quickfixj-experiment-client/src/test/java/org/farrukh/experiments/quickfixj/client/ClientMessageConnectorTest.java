package org.farrukh.experiments.quickfixj.client;

import org.farrukh.experiments.quickfixj.server.ServerAppStub;
import org.junit.After;
import org.junit.Test;

/**
 * Unit test for simple Application.
 */
public class ClientMessageConnectorTest {
    
    /**
     * Server app stub.
     */
    private ServerAppStub serverStub;
    
    /**
     * Subject under test.
     */
    private ClientMessageConnector sut;
    
    public ClientMessageConnectorTest() {
        serverStub = new ServerAppStub();
        serverStub.start();
        sut = new ClientMessageConnector();
    }

    @After
    public void tearDown() {
        sut.stop();
    }

    @Test
    public void testApp(){
        sut.start();
    }
    
}
