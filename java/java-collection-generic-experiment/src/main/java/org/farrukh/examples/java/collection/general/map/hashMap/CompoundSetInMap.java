package org.farrukh.examples.java.collection.general.map.hashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CompoundSetInMap {

	public static void main(String[] args) {

		Map<Set<Double>, Set<Double>> map = new HashMap<Set<Double>, Set<Double>>();
		Set<Double> keys = new TreeSet<Double>(Arrays.asList(new Double[] { 0.0, 1.0, 2.0, 8.0, 4.0, 5.0, 6.0, 7.0, 3.0, 9.0 }));
		Set<Double> values = new TreeSet<Double>(Arrays.asList(new Double[] { 1.0, 0.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 }));
		map.put(keys, values);
		System.out.println(map);
	}

}
