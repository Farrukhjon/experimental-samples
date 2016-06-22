package org.farrukh.examples.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.farrukh.examples.mongodb.connection.MongoConnectionUtil;
import org.mongodb.morphia.Datastore;

public class InsertAndRetrieveCollection {

    public static void main(String[] args) {

        Datastore db = MongoConnectionUtil.getInstance().getDatastore();

        DBCollection collection = db.getDB().getCollection("user");
        for (int i = 1; i <= 83; i++) {
            DBObject dbObj = new BasicDBObject("_id", i).append("name", "name" + i).append("password", "password" + i).append("age", i);
            collection.insert(dbObj);
        }
        DBCursor dbCursor = collection.find();
        while (dbCursor.hasNext()) {
            DBObject nextObj = dbCursor.next();
            System.out.println(nextObj);
        }
    }
}
