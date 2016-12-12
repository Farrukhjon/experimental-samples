package org.netty.server.experiment;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ServerAppTest {

    @Test
    public void shouldStartServerApp() throws InterruptedException {
        ServerApp server = new ServerApp(new MessageInboundHandler(), new MessageOutboundHandler());
        server.start();
    }
    
}
