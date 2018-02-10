package org.farrukh.experiments.dp.structural.decorator.ch1;

public class Client {

	public static void main(String[] args) {

		IIceCream iceCream = new HoneyDecorator(new SimpleIceCream());
		System.out.println(iceCream.makeIceCream());

		iceCream = new NuttyDecorator(new SimpleIceCream());
		System.out.println(iceCream.makeIceCream());

		iceCream = new HoneyDecorator(new NuttyDecorator(new SimpleIceCream()));
		System.out.println(iceCream.makeIceCream());
	}
}
