/**
 * 
 */
package org.examples.spring.rest.dto;

import java.io.Serializable;

/**
 * @author Farrukhjon SATTOROV
 *
 */

public class Product implements Serializable {

	private int id;
	private String name;
	private Customer customer;

	public Product() {
	}
	
	public Product(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
