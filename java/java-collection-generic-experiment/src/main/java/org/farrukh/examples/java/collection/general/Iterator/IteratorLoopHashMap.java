package org.farrukh.examples.java.collection.general.Iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorLoopHashMap {

	public static void main(String[] args) {
		Map<String, String> errors = new HashMap<String, String>();

		errors.put("404", "A.");
		errors.put("403", "B.");
		errors.put("500", "C.");

		String errorDesc = (String) errors.get("404");
		System.out.println("Error 404: " + errorDesc);

		Iterator<String> iterator = errors.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			System.out.println("Error " + key + " means " + errors.get(key));
		}
	}
}
