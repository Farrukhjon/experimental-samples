package org.farrukh.experiments.networking.mina;

import java.io.IOException;

import org.farrukh.experiments.networking.mina.time.TimeServer;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TimeServerTest {

    @Test
    public void shouldStartTimeServer() throws IOException {
        TimeServer.main(new String[]{});
        
    }
}
