package org.farrukh.examples.mongodb.dao;

import com.mongodb.MongoClient;
import org.farrukh.examples.mongodb.util.domain.User;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

/**
 * @author Farrukh SATTOROV 
 * */

public class UserDao extends BasicDAO<User, Object> {

	
	public UserDao(Class<User> entityClass, Datastore ds) {
		super(entityClass, ds);
	}

	public UserDao(Class<User> entityClass, MongoClient mongoClient, Morphia morphia, String dbName) {
		super(entityClass, mongoClient, morphia, dbName);
	}

	public UserDao(Datastore ds) {
		super(ds);
	}

	public UserDao(MongoClient mongoClient, Morphia morphia, String dbName) {
		super(mongoClient, morphia, dbName);
	}
}
