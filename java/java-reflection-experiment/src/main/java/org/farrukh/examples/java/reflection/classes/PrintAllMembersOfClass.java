package org.farrukh.examples.java.reflection.classes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrintAllMembersOfClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Method[] methods = Class.class.getMethods();
		Field[] fields = Class.class.getDeclaredFields();
		for (int i = 0; i < methods.length; i++) {
			String methodName = methods[i].getName();
			System.out.println(methodName);
		}
		for (int i = 0; i < fields.length; i++) {
			String fieldName = fields[i].getName();
			System.out.println(fieldName);
		}
	}

}
