package org.farrukh.examples.patterns.behavioral.strategy.ch2;

public class Quack implements QuackBehavior {
	
	@Override
	public void quack() {
		System.out.println("Quack!!!");
	}

}
