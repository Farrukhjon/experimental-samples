package org.farrukh.examples.java.reflection.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class InvokeMethodOfObject {

	public static void main(String[] args) {
		try {
			Object obj = Class.forName("method.Obj").newInstance();
			Method methodHello = obj.getClass().getMethod("hello", new Class<?>[0]);
			Method methodHelloParam = obj.getClass().getMethod("hello", String.class);
			methodHello.invoke(obj);
			methodHelloParam.invoke(obj, "World!");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
