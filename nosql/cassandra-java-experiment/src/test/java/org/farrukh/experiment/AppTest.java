package org.farrukh.experiment;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private static final String CLUSTER_NAME = "EmployeeCluster";

    final int defaultPort = 9044;
    final String nodeAddress = "127.0.0.1";

    private Session session;
    private Cluster cluster;

    private KeyspaceRepository keySpaceRepository;

    @Before
    public void setCassandraCluster() {
        cluster = Cluster
                .builder()
                .addContactPoint(nodeAddress)
                .withClusterName(CLUSTER_NAME)
                .build();
        session = cluster.connect();
        keySpaceRepository = new KeyspaceRepository(session);

    }

    public void close() {
        session.close();
        cluster.close();
    }

    @Test
    public void testCreatingKeySpace() {
        String keySpaceName = "employee_ks";
        keySpaceRepository.createKeyspace(keySpaceName, "SimpleStrategy", 1);
        ResultSet result = session.execute("SELECT * FROM system_schema.keyspaces;");
        Predicate<Row> rowPredicate = r -> r.getString(0).equals(keySpaceName.toLowerCase());
        boolean isKeySpaceCreated = result
                .all()
                .stream()
                .anyMatch(rowPredicate);
        assertTrue(isKeySpaceCreated);
    }

    @Test
    public void testWriteDataToTheEmployeeKeySpace() {
        session.execute("USE employee_ks");

        String createTable = "CREATE TABLE IF NOT EXISTS t (\n" +
                "a int,\n" +
                "b int,\n" +
                "c int,\n" +
                "d int,\n" +
                "PRIMARY KEY ((a, b), c, d)\n" +
                ")\n" +
                "\n" +
                "\n";

        ResultSet execute = session.execute(createTable);

    }
}
