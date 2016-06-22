/**
 * 
 */
package org.farrukh.examples.spring.data.rest.mongodb.domain;

import org.springframework.data.annotation.Id;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class Product {

	@Id
	private String id;

	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
