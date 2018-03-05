package org.farrukh.examples.java.collection.general.map.linkedHashMap;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LinkedHashMapDemo {

	public static void main(String[] args) {

		Map<Integer, String> lhm = new LinkedHashMap<Integer, String>();

		lhm.put(0, "zero");
		lhm.put(4, "four");
		lhm.put(5, "five");
		lhm.put(1, "one");
		lhm.put(3, "three");
		lhm.put(6, "six");
		lhm.put(2, "two");

		final Set<Entry<Integer, String>> entrySet = lhm.entrySet();
		System.out.printf("%-20s %1s", "entrySet().toString:", entrySet + "\n");

		final Object[] array = entrySet.toArray();
		System.out.printf("%-20s %1s", "entrySet().toArray:", Arrays.toString(array) + "\n");

		for (Map.Entry<Integer, String> entry : entrySet) {
			final Integer key = entry.getKey();
			final String value = entry.getValue();
			System.out.println("key = " + key + " value = " + value);
		}
		System.out.println(lhm);

		System.out.println("size: " + lhm.size());

		lhm.remove(4);

		System.out.println(lhm);

		System.out.println("size: " + lhm.size());

		for (Integer key : lhm.keySet())
			System.out.println("key: " + key + ", value: " + lhm.get(key));
	}

}
