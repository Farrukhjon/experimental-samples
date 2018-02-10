package org.farrukh.experiments.dp.structural.adapter.ch2;

import java.util.Random;

// Adaptee class
public class EnemyRobot {

	private Random	generate	= new Random();

	public void smashWithHeand() {
		int attackDamage = generate.nextInt(10) + 1;
		System.out.println("Enemy robot causes " + attackDamage + " Damages with its");
	}

	public void walkForward() {
		int movemant = generate.nextInt(5) + 1;
		System.out.println("Enemy Robot walk forward " + movemant + " space");
	}

	public void reactToHuman(String driver) {
		System.out.println("Enemy Robot Tramps on " + driver);
	}

}
