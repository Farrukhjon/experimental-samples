package org.farrukh.experiments.java.net;

import java.io.IOException;
import java.nio.charset.CharacterCodingException;
import java.util.concurrent.ExecutionException;

import org.farrukh.experiments.java.net.future.EchoClient;
import org.farrukh.experiments.java.net.future.EchoServer;
import org.junit.Test;

public class AppTest {

    @Test
    public void testApp() throws CharacterCodingException, IOException, InterruptedException, ExecutionException {
        new Thread() {
            public void run() {
                try {
                    EchoServer.main(new String[0]);
                } catch (IOException | InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            };
        }.start();
        for (int i = 0; i < 10; i++) {
            EchoClient.main(new String[0]);
        }
    }
}
