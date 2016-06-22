package org.farrukh.examples.patterns.structural.decorator.ch3;

public class Mocha extends CondimentDecorator {

	private Beverage	beverage;

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public double cost() {
		return beverage.cost() + 0.34;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

}
