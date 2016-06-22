/**
 * 
 */
package org.examples.spring.rest.dto;

import java.io.Serializable;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class Customer implements Serializable {

	private int id;
	private String name;

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

}
