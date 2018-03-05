package org.farrukh.examples.java.collection.general.map.hashTable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Farrukhjon SATTOROV
 * 
 */
public class DiffInHashtableAndHashMap {

	public static void main(String[] args) {

		Map<Integer, String> hashTable = new Hashtable<Integer, String>();
		Map<Integer, String> hashMap = new HashMap<Integer, String>();

		Map<Integer, String> map;
		
		int count = 0;
		map = hashTable;
		while (count < 2) {

			if (map instanceof Hashtable) {
				map.put(1, "");
				map.put(2, "two");
				map.put(3, "three");
			} else if (map instanceof HashMap) {
				map.put(1, null);
				map.put(2, "two");
				map.put(3, "three");
			}

			System.out.println("map instance of: " + map.getClass().getName());

			for (Integer i : map.keySet()) {
				System.out.println("map value: " + map.get(i));
			}
			map.clear();
			map = hashMap;
			count++;
		}
	}
}
