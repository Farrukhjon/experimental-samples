package org.farrukh.examples.java.reflection.classes;

public class ClassReflect {

	public static void main(String[] args) {
		Class clazz = "Str".getClass();
		if("str".getClass().equals(String.class))
			System.out.println("equals");
		System.out.println(clazz);
		System.out.println(String.class);
		System.out.println(Double.TYPE);
		System.out.println(Class.class.getSuperclass());
	}

}
