/**
 * 
 */
package org.examples.checkstyle.domain;

import java.io.Serializable;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class Product implements Serializable {

	private int id;
	private String name;
	private Customer customer;

	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public final void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the customer
	 */
	public final Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public final void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
