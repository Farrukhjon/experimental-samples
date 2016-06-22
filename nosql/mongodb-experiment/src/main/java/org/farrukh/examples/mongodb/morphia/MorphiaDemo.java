package org.farrukh.examples.mongodb.morphia;

import org.bson.types.ObjectId;
import org.farrukh.examples.mongodb.connection.MongoConnectionUtil;
import org.farrukh.examples.mongodb.morphia.domain.Deportament;
import org.farrukh.examples.mongodb.morphia.domain.Employee;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class MorphiaDemo {

	public static void main(String[] args) {

		Morphia morphia = MongoConnectionUtil.getInstance().getMorphia();
		morphia.map(Employee.class).map(Deportament.class);
		Datastore ds = MongoConnectionUtil.getInstance().createDatastore();

		// Saving the employee to mongodb
		Deportament deportament = new Deportament();
		deportament.setName("IT");

		Employee employee = new Employee();
		ObjectId id = new ObjectId();
		employee.setId(id);
		employee.setName("Ali");
		employee.setPosition("Developer");
		employee.setDeportament(deportament);

		ds.save(employee);

		// Loading the employee from mongodb

		Employee e = ds.get(Employee.class, id);

		System.out.println(e);
	}

}
