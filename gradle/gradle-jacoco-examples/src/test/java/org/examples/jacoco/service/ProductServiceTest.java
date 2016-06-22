/**
 * 
 */
package org.examples.jacoco.service;

import junit.framework.TestCase;

import org.examples.jacoco.dto.Product;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ProductServiceTest extends TestCase {
	
	private ProductService service = null;
	private Product product = null;
	
	@Before
	public void setUp(){
		service = new ProductService();
		product = new Product();
	}
	
	@Test
	public void testProduct(){
		
	}
	

}
