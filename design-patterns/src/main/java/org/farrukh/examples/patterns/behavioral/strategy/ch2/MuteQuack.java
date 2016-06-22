package org.farrukh.examples.patterns.behavioral.strategy.ch2;

public class MuteQuack implements QuackBehavior {
	
	@Override
	public void quack() {
		System.out.println("SilentAlertState quack...");
	}

}
