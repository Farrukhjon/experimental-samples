package org.farrukh.experiments.quickfixj.client;

import org.farrukh.experiments.quickfixj.server.ServerAppSub;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ClientAppTest {
    
    private ServerAppSub serverSub;
    
    private ClientApp sut;
    
    public ClientAppTest() {
        serverSub = new ServerAppSub();
        sut = new ClientApp();
    }

    @Before
    public void setup() {
        serverSub.start();
    }

    @Test
    public void testApp() {
        sut.start();
        Assert.assertTrue(true);
    }
    
    @After
    public void tearDown() {
        serverSub.stop();
        sut.stop();
    }
}
