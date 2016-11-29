package org.farrukh.experiments.java.net.server;

import org.farrukh.experiments.java.net.client.ClientApp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ServerAppTest {
    
    ServerApp server;
    
    ClientApp client; 
    
    @Before
    public void setup() {
      server = new ServerApp();
      client = new ClientApp();
    }

    @Test
    public void testApp() {
        String message = "Hello!, How are you";
        client.send(message);
        Assert.assertEquals(message, server.getMessages().get(0));
    }
    
    
    
}
