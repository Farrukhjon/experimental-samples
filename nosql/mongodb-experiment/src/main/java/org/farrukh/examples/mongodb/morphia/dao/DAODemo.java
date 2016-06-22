package org.farrukh.examples.mongodb.morphia.dao;

import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.farrukh.examples.mongodb.connection.MongoConnectionUtil;
import org.farrukh.examples.mongodb.morphia.domain.Deportament;
import org.farrukh.examples.mongodb.morphia.domain.Employee;
import org.mongodb.morphia.Morphia;

import java.util.List;

public class DAODemo {

	public static void main(String[] args) {
		
		MongoConnectionUtil mongoConnection = MongoConnectionUtil.getInstance();
		
		MongoClient mongo = mongoConnection.getMongoClient();
		Morphia morphia = mongoConnection.getMorphia();
		String dbName = mongoConnection.getDB().getName();
		
		EmployeeDAO employeeDao = new EmployeeDAO(mongo, morphia, dbName);
		
		Deportament deportament = new Deportament();
		deportament.setName("IT");

		Employee employee = new Employee();
		ObjectId id = new ObjectId();
		employee.setId(id);
		employee.setName("Vali");
		employee.setPosition("Bookkeeper");
		
		employeeDao.save(employee);

		List<Employee> all = employeeDao.find().asList();
		System.out.println(all);
	}

}
