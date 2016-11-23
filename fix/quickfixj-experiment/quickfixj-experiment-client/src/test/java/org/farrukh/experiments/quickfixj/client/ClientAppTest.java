package org.farrukh.experiments.quickfixj.client;

import org.farrukh.experiments.quickfixj.server.ServerAppSub;
import org.junit.After;
import org.junit.Test;

/**
 * Unit test for simple Application.
 */
public class ClientAppTest {
    
    /**
     * Server app stub.
     */
    private ServerAppSub serverSub;
    
    /**
     * Subject under test.
     */
    private ClientApp sut;
    
    public ClientAppTest() {
        serverSub = new ServerAppSub();
        serverSub.start();
        sut = new ClientApp();
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
