/**
 * 
 */
package org.example.spring.data.hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Farrukhjon SATTOROV
 *
 */
@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	public Product(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
