package org.farrukh.examples.patterns.creational.factoryMethod.ch2;

public class Client {

	public static void main(String[] args) {

		IFactoryProduct factoryProduct = new FactoryProduct();
		
		IProduct product1 = factoryProduct.createProduct("Product1");
		product1.operation1();
		product1.operation2();
		
		IProduct product2 = factoryProduct.createProduct("Product2");
		product2.operation1();
		product2.operation2();
	}
}
