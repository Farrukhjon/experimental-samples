/**
 * 
 */
package org.examples.spring.boot.amqp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class Product {

	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;

	public Product() {
		// TODO Auto-generated constructor stub
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
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}

}
