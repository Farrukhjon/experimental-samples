/**
 * 
 */
package org.examples.jaxb.basic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.examples.jaxb.domain.Employee;
import org.examples.jaxb.domain.Employees;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class MarshalingListDemo {

	static Employees employees = new Employees();
	static {
		Employee emp1 = new Employee(1, "emp1");
		Employee emp2 = new Employee(2, "emp2");
		Employee emp3 = new Employee(3, "emp3");
		employees.setEmployees(new ArrayList<Employee>());
		employees.getEmployees().add(emp1);
		employees.getEmployees().add(emp2);
		employees.getEmployees().add(emp3);
	}
	
	public static void main(String[] args) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Employees.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(employees, new File("src/org/examples/jaxb/xml/employees.xml"));
	}

}
