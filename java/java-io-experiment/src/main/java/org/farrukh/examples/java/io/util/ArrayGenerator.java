package org.farrukh.examples.java.io.util;

import java.util.Random;

public abstract class ArrayGenerator {

	public static Integer[] getInteger(Integer size) {
		Integer[] a = new Integer[size];
		Random r = new Random();
		for(Integer i = 0; i < a.length; i++){
			a[i] = r.nextInt(100);
		}
		return a;
	}
	
}
