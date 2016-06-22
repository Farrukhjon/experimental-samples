package org.farrukh.examples.java.reflection.classes;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class GetGenParam<T extends Number, K extends Serializable> {

	public static void main(String[] args) {
		GetGenParam ggp = new GetGenParam<Integer, Serializable>();
		ggp.printClassParam();
		ggp.printConstructorParam();
	}

	public <E extends Object> GetGenParam() {
	}

	private void printClassParam() {
		try {
			Class c = Class.forName("reflection.classes.GetGenParam");
			TypeVariable[] tvs = c.getTypeParameters();
			for (TypeVariable tv : tvs) {
				Type[] types = tv.getBounds();
				for (Type type : types) {
					Class clazz = (Class) type;
					System.out.println(clazz.getSimpleName());
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}

	private void printConstructorParam() {
		try {
			Class c = Class.forName("reflection.classes.GetGenParam");
			TypeVariable[] tvs = c.getConstructor().getTypeParameters();
			for (TypeVariable tv : tvs) {
				Type[] types = tv.getBounds();
				for (Type type : types) {
					Class clazz = (Class) type;
					System.out.println(clazz.getSimpleName());
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
