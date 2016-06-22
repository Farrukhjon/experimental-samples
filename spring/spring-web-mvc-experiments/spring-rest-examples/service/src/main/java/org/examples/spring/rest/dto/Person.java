/**
 * 
 */
package org.examples.spring.rest.dto;

import java.io.Serializable;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class Person implements Serializable {

	private int id;
	private String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Person() {
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
		return "Person [id=" + id + ", name=" + name + "]";
	}

}
