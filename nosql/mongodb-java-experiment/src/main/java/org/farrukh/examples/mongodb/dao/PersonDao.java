package org.farrukh.examples.mongodb.dao;

import org.farrukh.examples.mongodb.connection.MongoConnectionUtil;
import org.farrukh.examples.mongodb.util.domain.User;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

public class PersonDao extends BasicDAO<User, Object> {

	public PersonDao(Class<User> entityClass, Datastore ds) {
		super(entityClass, ds);
	}
	
	public PersonDao() {
		this(User.class, MongoConnectionUtil.getInstance().getDatastore());
	}

}
