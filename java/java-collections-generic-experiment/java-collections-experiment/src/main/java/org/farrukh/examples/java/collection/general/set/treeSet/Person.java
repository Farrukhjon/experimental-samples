package org.farrukh.examples.java.collection.general.set.treeSet;

public class Person {

	private int	id;

	public Person(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "person" + id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

}
