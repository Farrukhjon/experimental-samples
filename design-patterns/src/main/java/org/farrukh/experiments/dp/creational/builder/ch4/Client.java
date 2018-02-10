package org.farrukh.experiments.dp.creational.builder.ch4;

public class Client {

	public static void main(String[] args) {

		RobotBuilder oldStyleRobotBuilder = new OldRobotBuilder();

		RobotEngeneer robotEngeneer = new RobotEngeneer(oldStyleRobotBuilder);

		robotEngeneer.makeRobot();

		Robot firstOldStyleRobot = robotEngeneer.getRobot();
		System.out.println("Robot Built");

		System.out.printf("%-17s %1s", "Robot Head Type:", firstOldStyleRobot.getRobotHead() + "\n");
		System.out.printf("%-17s %1s", "Robot Torso Type:", firstOldStyleRobot.getRobotTorso() + "\n");
		System.out.printf("%-17s %1s", "Robot Arms Type:", firstOldStyleRobot.getRobotArms() + "\n");
		System.out.printf("%-17s %1s", "Robot Legs Type:", firstOldStyleRobot.getRobotLegs() + "\n");
	}

}
