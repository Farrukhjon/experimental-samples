package org.farrukh.examples.patterns.behavioral.strategy.ch2;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can't flying");
	}

}
