/**
 * 
 */
package org.examples.jaxb.basic;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.examples.jaxb.domain.Employee;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class UnmarshalingDemo {
	
	public static void main(String[] args) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Employee.class);
	}
}
