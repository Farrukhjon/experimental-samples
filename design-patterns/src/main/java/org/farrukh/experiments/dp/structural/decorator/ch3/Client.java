package org.farrukh.experiments.dp.structural.decorator.ch3;

public class Client {

	public static void main(String[] args) {

		Beverage beverage = new Espresso();
		beverage.setSize(3);
		System.out.println(beverage.getDescription() + " $" + beverage.cost());

		final Beverage beverage2 = new Whip(new Mocha(new DarkRoast()));
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

	}

}
