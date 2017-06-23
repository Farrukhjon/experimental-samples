package org.farrukh.http;

import org.farrukh.http.server.HttpJettyServer;
import org.junit.Test;

public class CalculatorAppTest {

    @Test
    public void runAsyncServer() throws Exception {
        new HttpJettyServer();
    }


}
