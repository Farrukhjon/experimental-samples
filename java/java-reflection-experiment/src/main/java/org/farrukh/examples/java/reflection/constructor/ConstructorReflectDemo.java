package org.farrukh.examples.java.reflection.constructor;

import java.lang.reflect.Constructor;

import org.farrukh.examples.java.reflection.constructor.Car.CarColor;

public class ConstructorReflectDemo {

	public static void main(String[] args) {

		Car car = new Car("Opel", CarColor.Green);
		System.out.println(car);
		Class<?> clazz = car.getClass();
		Object obj = null;
		Constructor<?>[] constructors = clazz.getConstructors();
		Constructor<?> con = constructors[1];
		try {
			obj = con.newInstance("Volvo", CarColor.Black);
			System.out.println(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Constructor<?>[] cons = Car.class.getConstructors();
		Constructor<?> con1 = cons[1];
		try {
			obj = con1.newInstance("Lada calina", CarColor.Red);
			System.out.println(obj);
		} catch (Exception e) {
		}
	}
}
