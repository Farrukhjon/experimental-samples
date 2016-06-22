/**
 * 
 */
package org.examples.jaxb.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.examples.jaxb.domain.Employee;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class MarshallingDemo {

	public static void main(String[] args) throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(Employee.class);
		Marshaller marshaller = context.createMarshaller();
		Employee employee = new Employee(1, "emp1");
		File file = new File("src/org/examples/jaxb/xml/employee.xml");
		file.createNewFile();
		OutputStream out = new FileOutputStream(file);
		marshaller.marshal(employee, out);
	}

}
