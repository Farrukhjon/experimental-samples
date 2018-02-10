package org.farrukh.experiments.dp.creational.builder.ch4;

public interface RobotBuilder {

	public void buildRobotHead();

	public void buildRobotTorso();

	public void buildRobotArms();

	public void buildRobotLegs();
	
	public Robot getRobot();

}
