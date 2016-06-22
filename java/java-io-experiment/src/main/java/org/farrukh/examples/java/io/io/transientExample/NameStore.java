package org.farrukh.examples.java.io.io.transientExample;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NameStore implements Serializable {

	private String				firstName;
	private transient String	middleName;
	private String				lastName;

	public NameStore(String fName, String mName, String lName) {
		this.firstName = fName;
		this.middleName = mName;
		this.lastName = lName;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(40);
		sb.append(" First Name: ");
		sb.append(this.firstName + ", ");
		sb.append("Middle Name: ");
		sb.append(this.middleName + ", ");
		sb.append(" Last Name: ");
		sb.append(this.lastName + ".");
		return sb.toString();
	}

}
