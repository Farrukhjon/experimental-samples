package org.farrukh.experiments.dp.creational.builder.ch2;

/* "ConcreteBuilder" */
public class SpicyPizzaBuilder extends PizzaBuilder {

	@Override
	public void buildDough() {
		pizza.setDough("pan backed");
	}

	@Override
	public void buildSouce() {
		pizza.setSouce("hot");
	}

	@Override
	public void buildTopping() {
		pizza.setTopping("pepperoni+salami");
	}
}
