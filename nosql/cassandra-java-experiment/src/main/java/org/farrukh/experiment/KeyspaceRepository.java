package org.farrukh.experiment;

import com.datastax.driver.core.Session;

public class KeyspaceRepository {

    private final Session session;


    public KeyspaceRepository(Session session) {
        this.session = session;
    }

    public void createKeyspace(String keySpaceName, String replicaStrategy, int numberOfReplicas) {
        if (replicaStrategy == null || "".endsWith(replicaStrategy))
            replicaStrategy = "SimpleStrategy";
        String cql = new StringBuilder("CREATE KEYSPACE IF NOT EXISTS ")
                .append(keySpaceName)
                .append(" WITH replication = { ")
                .append("'class':'")
                .append(replicaStrategy)
                .append("','replication_factor': ")
                .append(numberOfReplicas)
                .append("};")
                .toString();
        session.execute(cql);
    }

}
