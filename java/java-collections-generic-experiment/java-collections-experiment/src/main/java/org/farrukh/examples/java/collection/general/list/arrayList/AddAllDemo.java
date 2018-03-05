package org.farrukh.examples.java.collection.general.list.arrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class AddAllDemo {

	public static void main(String[] args) {

		List<Integer> array = new ArrayList<Integer>();
		array.add(9);
		array.add(2);
		array.add(3);
		array.add(1);
		array.add(0);

		Vector<Integer> vector = new Vector<Integer>();
		vector.add(5);
		vector.add(4);
		vector.add(6);
		vector.add(7);
		vector.add(8);

		array.addAll(vector);

	}

}
