package org.farrukh.experiments.dp.behavioral.strategy.ch1;

public class Client {

	public static void main(String[] args) {

		Robot r1 = new Robot("R1");
		Robot r2 = new Robot("R2");
		Robot r3 = new Robot("R3");

		r1.setStrategy(new NormalBehavior());
		r2.setStrategy(new AgressiveBehavior());
		r3.setStrategy(new DefensiveBehavior());

		r1.move();
		r2.move();
		r3.move();
	}
}
