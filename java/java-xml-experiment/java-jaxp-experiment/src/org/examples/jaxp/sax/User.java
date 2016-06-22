/**
 * 
 */
package org.examples.jaxp.sax;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class User {

	// XML attribute id
	private int id;
	// XML element fisrtName
	private String firstName;
	// XML element lastName
	private String lastName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return this.id + ":" + this.firstName + ":" + this.lastName;
	}

}
