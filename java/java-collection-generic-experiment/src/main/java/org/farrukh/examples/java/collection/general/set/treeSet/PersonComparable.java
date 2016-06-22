package org.farrukh.examples.java.collection.general.set.treeSet;

public class PersonComparable implements Comparable<PersonComparable> {

	private int	id;

	public PersonComparable(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(PersonComparable o) {
		return (this.id < o.getId()) ? -1 : (this.id > o.getId()) ? 1 : 0;
	}

	@Override
	public String toString() {
		return "person" + id;
	}

	public int getId() {
		return id;
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
		PersonComparable other = (PersonComparable) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
