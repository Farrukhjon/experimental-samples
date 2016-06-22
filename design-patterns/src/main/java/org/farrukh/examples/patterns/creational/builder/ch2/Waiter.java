package org.farrukh.examples.patterns.creational.builder.ch2;

/**
 * @author Farrukhjon SATTOROV
 */
public class Waiter {

	private PizzaBuilder	pizzaBuilder;

	public void constructPizza() {
		pizzaBuilder.createNewPizzaProduct();
		pizzaBuilder.buildDough();
		pizzaBuilder.buildSouce();
		pizzaBuilder.buildTopping();
	}

	public Pizza getPizza() {
		return pizzaBuilder.getPizza();
	}

	public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
		this.pizzaBuilder = pizzaBuilder;
	}
}
