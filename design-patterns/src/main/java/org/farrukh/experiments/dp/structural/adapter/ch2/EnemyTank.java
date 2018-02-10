package org.farrukh.experiments.dp.structural.adapter.ch2;

import java.util.Random;

public class EnemyTank implements IEnemyAttacker {

	private Random	generate	= new Random();

	@Override
	public void fireWeapon() {
		int attackDamage = generate.nextInt(10) + 1;
		System.out.println("Enemy Tank Does " + attackDamage + " Damage");
	}

	@Override
	public void driveForward() {
		int movenamt = generate.nextInt(7) + 1;
		System.out.println("Enemy Tank movment " + movenamt + "space");
	}

	@Override
	public void assignDriver(String driver) {
		System.out.println(driver + "drive a tank");
	}

}
