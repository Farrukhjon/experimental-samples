package org.farrukh.experiments.dp.creational.builder.ch2;

public class Client {

	public static void main(String[] args) {

		Waiter waiter = new Waiter();

		PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
		PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();

		waiter.setPizzaBuilder(hawaiianPizzaBuilder);
		waiter.constructPizza();
		
		Pizza pizza = waiter.getPizza();
		System.out.println(pizza.getClass().getName());

		waiter.setPizzaBuilder(spicyPizzaBuilder);
		waiter.constructPizza();
		
		Pizza pizza2 = waiter.getPizza();
		System.out.println(pizza2.getClass().getName());
	}
}
