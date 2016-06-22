package org.neo4jexamples;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class HelloNeo4j {

	public static void main(String[] args) {
		String path = "C:\\Users\\Farrukhjon\\Documents\\Neo4j\\default.graphdb";
		GraphDatabaseService databaseService = new GraphDatabaseFactory().newEmbeddedDatabase(path);
		Transaction transaction = databaseService.beginTx();
		try {
			Node firstNode = databaseService.createNode();
			firstNode.setProperty("name", "Jura");
			Node secondNode = databaseService.createNode();
			secondNode.setProperty("name", "Halim");
			transaction.success();
			for (int i = 0; i < 4; i++) {
				System.out.println(databaseService.getNodeById(i).getProperty("name"));
			}

		} finally {
			transaction.close();
		}
	}

}
