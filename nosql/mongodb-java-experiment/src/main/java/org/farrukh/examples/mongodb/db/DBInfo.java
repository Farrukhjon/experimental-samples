package org.farrukh.examples.mongodb.db;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import org.farrukh.examples.mongodb.connection.MongoConnectionUtil;
import org.mongodb.morphia.Datastore;

/**
 * @author Farrukh SATTOROV 
 * */

public class DBInfo {

	public static void main(String[] args) {

		Datastore datasource = MongoConnectionUtil.getInstance().getDatastore();
		DB db = datasource.getDB();
		String name = db.getName();
		System.out.println("Name of db is: " + name);

		ReadPreference readPreference = db.getReadPreference();
		System.out.printf("%-7s %b %n ", readPreference.getName(), readPreference.isSlaveOk());

		Mongo mongo = db.getMongo();

		ServerAddress address = mongo.getAddress();
		String host = address.getHost();
		int port = address.getPort();

		System.out.printf("%-10s %1s", "the host:" + host, ", the port: " + port);

	}

}
