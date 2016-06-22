package org.farrukh.examples.patterns.creational.singleton;

/**
 * @author Farrukhjon SATTOROV
 */
public class SingletonDemo {

	private static SingletonDemo	instance;

	public static SingletonDemo getInstance() {
		return (instance == null) ? instance = new SingletonDemo() : instance;
	}

	private SingletonDemo() {
	}

	public static void main(String[] args) {
		SingletonDemo singletonDemo1 = SingletonDemo.getInstance();
		SingletonDemo singletonDemo2 = SingletonDemo.getInstance();
		System.out.println(singletonDemo1);
		System.out.println(singletonDemo2);
	}
}
