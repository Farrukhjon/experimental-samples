package org.farrukh.experiments.dp.structural.adapter.ch2;

public class Client {

	public static void main(String[] args) {

		EnemyRobot robot = new EnemyRobot();

		IEnemyAttacker robotAdapter = new EnemyRobotAdapter(robot);

		robot.reactToHuman("Paul");
		robot.walkForward();
		robot.smashWithHeand();

		robotAdapter.assignDriver("Ivan");
		robotAdapter.driveForward();
		robotAdapter.fireWeapon();

	}

}
