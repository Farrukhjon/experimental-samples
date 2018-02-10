package org.farrukh.experiments.dp.creational.singleton;

/**
 * @author Farrukhjon SATTOROV
 */
public class SingletonClient {

	private static SingletonClient instance;

	public static SingletonClient getInstance() {
		return (instance == null) ? instance = new SingletonClient() : instance;
	}

	private SingletonClient() {
	}

	public static void main(String[] args) {
		SingletonClient singletonDemo1 = SingletonClient.getInstance();
		SingletonClient singletonDemo2 = SingletonClient.getInstance();
		System.out.println(singletonDemo1);
		System.out.println(singletonDemo2);
	}
}
