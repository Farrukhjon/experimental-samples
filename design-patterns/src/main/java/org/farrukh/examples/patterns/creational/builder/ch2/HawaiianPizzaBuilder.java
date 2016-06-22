package org.farrukh.examples.patterns.creational.builder.ch2;

/* ConcreteBuilder */
public class HawaiianPizzaBuilder extends PizzaBuilder {

	@Override
	public void buildDough() {
		pizza.setDough("cross");
	}

	@Override
	public void buildSouce() {
		pizza.setSouce("mild");
	}

	@Override
	public void buildTopping() {
		pizza.setTopping("ham+pineapple");
	}
}
