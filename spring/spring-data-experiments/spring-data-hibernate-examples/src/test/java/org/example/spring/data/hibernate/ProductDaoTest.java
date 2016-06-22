/**
 * 
 */
package org.example.spring.data.hibernate;

import org.example.spring.data.hibernate.dao.ProductDao;
import org.example.spring.data.hibernate.dto.Product;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ProductDaoTest {
	
	@Autowired
	private ProductDao dao;
	
	private Product computer;
	private Product printer;
	private Product phone;
	
	@Before
	public void setup(){
		computer = new Product("Computer");
		printer = new Product("Printer");
		phone = new Product("Phone");
	}
	
	@Test
	public void testProduct(){
		
	}
	
	
	
	
}
