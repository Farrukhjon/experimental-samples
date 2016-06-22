package org.farrukh.examples.patterns.behavioral.strategy.ch2;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I'm flaing with wings");
	}

}
