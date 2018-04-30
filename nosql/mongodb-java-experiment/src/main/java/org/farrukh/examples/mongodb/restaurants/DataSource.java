package org.farrukh.examples.mongodb.restaurants;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DataSource {

    private final String host = "localhost";
    private final int port = 27017;
    private final String databaseName = "test";
    private final String collectionName = "restaurants";

    private final MongoCollection<Document> collection;

    public DataSource() {
        MongoClient client = new MongoClient(host, port);
        MongoDatabase database = client.getDatabase(databaseName);
        this.collection = database.getCollection(collectionName);
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }
}
