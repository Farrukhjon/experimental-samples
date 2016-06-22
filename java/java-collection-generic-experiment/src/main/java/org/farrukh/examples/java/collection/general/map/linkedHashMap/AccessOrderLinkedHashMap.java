package org.farrukh.examples.java.collection.general.map.linkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class AccessOrderLinkedHashMap {

	public static void main(String[] args) {

		Map<Integer, String> lhm = new LinkedHashMap<>(16, 0.75f, true);

		lhm.put(0, "zero");
		lhm.put(4, "four");
		lhm.put(5, "five");
		lhm.put(1, "one");
		lhm.put(3, "three");
		lhm.put(6, "six");
		lhm.put(2, "two");
		
		System.out.println(lhm.keySet());
		System.out.println(lhm.values());
		
		System.out.println(lhm);
	}

}
