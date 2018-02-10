package org.farrukh.experiments.dp.structural.decorator.ch3;

public class HouseBlend extends Beverage {

	public HouseBlend() {
		description = "House blend";
	}
	
	@Override
	public double cost() {
		return 1.45;
	}
	
}
