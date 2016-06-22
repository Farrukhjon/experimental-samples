package org.farrukh.examples.mongodb;

import java.util.List;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.farrukh.examples.mongodb.connection.MongoConnectionUtil;
import org.mongodb.morphia.Datastore;

public class LimitNumberOfDocuments {

	public static void main(String[] args) {

		Datastore db = MongoConnectionUtil.getInstance().getDatastore();

		DBCollection collection = db.getDB().getCollection("user");
		
		DBCursor cursor = collection.find();
		
		List<DBObject> users = cursor.limit(10).toArray();
		
		for (DBObject o : users) {
			System.out.println(o);
		}

	}
}
