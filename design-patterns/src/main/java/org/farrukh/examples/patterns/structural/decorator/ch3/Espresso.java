package org.farrukh.examples.patterns.structural.decorator.ch3;

public class Espresso extends Beverage {

	public Espresso() {
		description = "Espresso";
	}
	
	@Override
	public double cost() {
		return size * 3.21;
	}

}
