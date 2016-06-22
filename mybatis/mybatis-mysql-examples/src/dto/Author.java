package dto;

import java.io.Serializable;

public class Author implements Serializable {

	private long	id;
	private Person	person;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
