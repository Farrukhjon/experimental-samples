package org.farrukh.examples.mongodb.connection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.DatastoreImpl;
import org.mongodb.morphia.Morphia;

/**
 * @author Farrukh SATTOROV
 *         <p>
 *         connecting to defulat database: C:/data/db MongoConnectionUtil is the
 *         simple toy utility
 */

public class MongoConnectionUtil {

    private static final String HOST = "localhost";
    private static final String DB_NAME = "testdb";
    private static final int port = 27017;
    private static MongoConnectionUtil instance = null;
    private MongoDatabase db = null;
    private MongoClient mongoClient;
    private Morphia morphia;

    private MongoConnectionUtil() {
        mongoClient = new MongoClient(HOST, port);
        db = mongoClient.getDatabase(DB_NAME);
        morphia = new Morphia();
    }

    public static MongoConnectionUtil getInstance() {
        return (instance != null) ? instance : (instance = new MongoConnectionUtil());
    }

    public MongoDatabase getDB() {
        return db;
    }

    public Datastore getDatastore() {
        return new DatastoreImpl(morphia, mongoClient, DB_NAME);
    }

    public Morphia getMorphia() {
        return morphia;
    }

    public Datastore createDatastore() {
        return morphia.createDatastore(mongoClient, DB_NAME);
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

}
