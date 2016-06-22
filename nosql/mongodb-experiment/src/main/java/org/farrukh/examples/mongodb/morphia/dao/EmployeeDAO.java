package org.farrukh.examples.mongodb.morphia.dao;


import org.farrukh.examples.mongodb.morphia.domain.Employee;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import org.mongodb.morphia.dao.BasicDAO;

public class EmployeeDAO extends BasicDAO<Employee, String> {

	public EmployeeDAO(MongoClient mongo, Morphia morphia, String dbName) {
		super(mongo, morphia, dbName);
	}

}
