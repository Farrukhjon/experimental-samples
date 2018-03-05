package org.farrukh.examples.java.collection.general.array;

import java.util.Arrays;

public class ArrayEquality {

	public static void main(String args[]) {

		String[] cities = new String[] { "London", "Paris", "NewYork", "HongKong", "Tokyo" };
		String[] metros = new String[] { "London", "Paris", "NewYork", "HongKong", "Tokyo" };
		String[] capitals = cities;

		// comparing array using == operator
		System.out.println("cities == metros : " + (cities == metros));
		System.out.println("cities == capitals : " + (cities == capitals));

		// comparing array using equals() method
		System.out.println("cities.equals(metros) : " + cities.equals(metros));
		System.out.println("cities.equals(capitals) : " + cities.equals(capitals));

		// comparing array using Arrays.equals() method
		System.out.println("Arrays.equals(cities, metros) : " + Arrays.equals(cities, metros));
		System.out.println("Arrays.equals(cities, capitals) : " + Arrays.equals(cities, capitals));

	}
}
