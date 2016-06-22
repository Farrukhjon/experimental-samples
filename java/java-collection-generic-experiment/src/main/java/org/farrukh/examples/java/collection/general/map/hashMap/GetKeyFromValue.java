package org.farrukh.examples.java.collection.general.map.hashMap;

import java.util.HashMap;
import java.util.Map;

public class GetKeyFromValue {

	public static void main(String[] argv) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");
		map.put("4", "four");

		System.out.println(getKeyFromValue(map, "three"));
	}

	public static Object getKeyFromValue(Map<String, String> hm, Object value) {
		for (Object obj : hm.keySet()) {
			if (hm.get(obj).equals(value)) {
				return obj;
			}
		}
		return null;
	}
}
