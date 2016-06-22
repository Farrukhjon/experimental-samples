package org.farrukh.examples.java.collection.general.set.treeSet;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SortHashsetWithComparator {

	public static void main(String[] args) {

		Set<Person> unsortedSet = new HashSet<>();
		unsortedSet.add(new Person(4));
		unsortedSet.add(new Person(2));
		unsortedSet.add(new Person(3));
		unsortedSet.add(new Person(1));
		unsortedSet.add(new Person(4));
		unsortedSet.add(new Person(1));
		unsortedSet.add(new Person(5));

		System.out.println(unsortedSet);

		Set<Person> sortedSet = new TreeSet<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return (o1.getId() < o2.getId()) ? -1 : (o1.getId() > o2.getId()) ? 1 : 0;
			}
		});
		sortedSet.addAll(unsortedSet);

		System.out.println(sortedSet);

		Set<PersonComparable> unsortedSet2 = new HashSet<>();
		unsortedSet2.add(new PersonComparable(1));
		unsortedSet2.add(new PersonComparable(3));
		unsortedSet2.add(new PersonComparable(2));
		unsortedSet2.add(new PersonComparable(5));
		unsortedSet2.add(new PersonComparable(4));
		System.out.println(unsortedSet2);

		Set<PersonComparable> sortedSet2 = new TreeSet<>(unsortedSet2);
		System.out.println(sortedSet2);
	}

}
