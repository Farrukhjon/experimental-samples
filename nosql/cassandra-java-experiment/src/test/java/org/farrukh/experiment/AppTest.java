package org.farrukh.experiment;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Predicate;

/**
 * Unit test for simple App.
 */
public class AppTest {

    final int defaultPort = 9044;
    final String nodeAddress = "127.0.0.1";

    private Session session;
    private Cluster cluster;

    private KeyspaceRepository keyspaceRepository;

    @Before
    public void setUpEmbeddedCassandra() throws Exception {
        /*EmbeddedCassandraServerHelper.startEmbeddedCassandra(2000L);*/
        cluster = Cluster
                .builder()
                .addContactPoint(nodeAddress)
                .build();
        session = cluster.connect();

        keyspaceRepository = new KeyspaceRepository(session);
    }

    public void close() {
        session.close();
        cluster.close();
    }

    @Test
    public void testCreatingKeySpace() {
        String keySpaceName = "employee_ks";
        keyspaceRepository.createKeyspace(keySpaceName, "SimpleStrategy", 1);
        ResultSet result = session.execute("SELECT * FROM system_schema.keyspaces;");
        Predicate<Row> rowPredicate = r -> r.getString(0).equals(keySpaceName.toLowerCase());
        boolean isKeyspaceCreated = result
                .all()
                .stream()
                .anyMatch(rowPredicate);
        Assert.assertTrue(isKeyspaceCreated);
    }
}
