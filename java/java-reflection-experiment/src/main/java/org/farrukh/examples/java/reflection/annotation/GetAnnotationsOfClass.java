package org.farrukh.examples.java.reflection.annotation;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

public class GetAnnotationsOfClass {

	public static void main(String[] args) {
		Class<?> c = ArrayList.class;
		Annotation[] a = c.getAnnotations();
		for (Annotation cAn : a) {
			System.out.println(cAn.annotationType());
		}
	}
}
