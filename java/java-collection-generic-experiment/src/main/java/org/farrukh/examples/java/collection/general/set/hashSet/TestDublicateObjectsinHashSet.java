package org.farrukh.examples.java.collection.general.set.hashSet;

import java.util.HashSet;
import java.util.Set;

public class TestDublicateObjectsinHashSet {

	public static void main(String[] args) {

		Set<Person> personSet = new HashSet<Person>();

		Person person1 = new Person("person1", 1);
		Person person2 = new Person("person1", 1);
		Person person3 = new Person("person1", 1);

		personSet.add(person1);
		personSet.add(person2);
		personSet.add(person3);

		System.out.println(personSet);

	}

	private static class Person {

		private String	name;
		private int		id;

		public Person(String name, int id) {
			this.name = name;
			this.id = id;
		}

		public Person(String name) {
			this.name = name;
		}

		@Override
		public int hashCode() {
			return super.hashCode();
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
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return name;
		}
	}
}
