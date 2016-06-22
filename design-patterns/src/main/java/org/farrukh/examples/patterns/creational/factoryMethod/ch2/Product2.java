package org.farrukh.examples.patterns.creational.factoryMethod.ch2;

public class Product2 implements IProduct {

	public Product2() {
	}

	@Override
	public void operation1() {
		System.out.println(Product2.class.getName());
	}

	@Override
	public void operation2() {
		System.out.println(Product2.class.getSimpleName());
	}
}
