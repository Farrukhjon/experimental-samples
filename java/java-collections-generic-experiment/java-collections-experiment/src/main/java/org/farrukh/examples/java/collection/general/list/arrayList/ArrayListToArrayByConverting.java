package org.farrukh.examples.java.collection.general.list.arrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListToArrayByConverting {

	public static void main(String args[]) {

		ArrayList<String> aListMonth = new ArrayList<String>();
		aListMonth.add("Jan");
		aListMonth.add("Feb");
		aListMonth.add("mar");

		Object[] objMnt = aListMonth.toArray();

		String[] strMnts = Arrays.copyOf(objMnt, objMnt.length, String[].class);

		System.out.println("ArrayList converted to String array");

		for (int i = 0; i < strMnts.length; i++) {
			System.out.println(strMnts[i]);
		}
	}
}
