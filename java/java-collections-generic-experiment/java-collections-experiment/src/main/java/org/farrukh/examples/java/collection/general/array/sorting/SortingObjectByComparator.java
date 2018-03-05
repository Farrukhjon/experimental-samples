package org.farrukh.examples.java.collection.general.array.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class SortingObjectByComparator {

	public static void main(String[] args) {

		Course[] courses = new Course[4];
		courses[0] = new Course(101, "Java", 200);
		courses[1] = new Course(201, "Ruby", 300);
		courses[2] = new Course(301, "Python", 400);
		courses[3] = new Course(401, "Scala", 500);

		System.out.println("Object array before sorting : " + Arrays.toString(courses));
		Arrays.sort(courses);
		System.out.println("Object array after sorting in natural order : " + Arrays.toString(courses));

		Arrays.sort(courses, new PriceComparator());
		System.out.println("Object array after sorting by price : " + Arrays.toString(courses));

		Arrays.sort(courses, new NameComparator());
		System.out.println("Object array after sorting by name : " + Arrays.toString(courses));
	}

	public static class Course implements Comparable<Course> {
		int		id;
		String	name;
		int		price;

		public Course(int id, String name, int price) {
			this.id = id;
			this.name = name;
			this.price = price;
		}

		@Override
		public int compareTo(Course c) {
			return this.id - c.id;
		}

		@Override
		public String toString() {
			return String.format("#%d %s@%d ", id, name, price);
		}
	}

	public static class PriceComparator implements Comparator<Course> {
		@Override
		public int compare(Course c1, Course c2) {
			return c1.price - c2.price;
		}
	}

	public static class NameComparator implements Comparator<Course> {
		@Override
		public int compare(Course c1, Course c2) {
			return c1.name.compareTo(c2.name);
		}
	}

	public static class ColumnComparator implements Comparator<Comparable[]> {

		private final int			iColumn;
		private final SortingOrder	order;

		public ColumnComparator(int column, SortingOrder order) {
			this.iColumn = column;
			this.order = order;
		}

		@Override
		public int compare(Comparable[] c1, Comparable[] c2) {
			int result = c1[iColumn].compareTo(c2[iColumn]);
			return order == SortingOrder.ASCENDING ? result : -result;
		}
	}

	enum SortingOrder {
		ASCENDING, DESCENDING;
	};

}
