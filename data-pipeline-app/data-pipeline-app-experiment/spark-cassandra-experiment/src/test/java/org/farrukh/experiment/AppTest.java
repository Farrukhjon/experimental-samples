package org.farrukh.experiment;

import static org.junit.Assert.assertTrue;

import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

    @Before
    public void setUp() throws Exception {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra(); //default configurations are used: cu-cassandra.yaml
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
