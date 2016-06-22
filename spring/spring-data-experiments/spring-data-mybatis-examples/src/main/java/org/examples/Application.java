/**
 * 
 */
package org.examples;

import org.examples.dao.ProductMapper;
import org.examples.dto.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Farrukhjon SATTOROV
 *
 */

public class Application {

	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:appContext.xml");
		
		ProductMapper productMapper = appContext.getBean(ProductMapper.class);
		for(Product p: productMapper.findAll()){
			System.out.println(p);
		}
		
	}

}
