package org.farrukh.examples.java.reflection.constructor;

import java.lang.reflect.Constructor;

public class GetConstructorsFromString {

	public static void main(String[] args) {

		Constructor<?>[] constructor = String.class.getConstructors();
		for (int i = 0; i < constructor.length; i++) {
			System.out.println(constructor[i]);
		}
	}
}
