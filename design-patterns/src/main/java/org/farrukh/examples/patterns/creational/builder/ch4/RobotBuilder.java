package org.farrukh.examples.patterns.creational.builder.ch4;

public interface RobotBuilder {

	public void buildRobotHead();

	public void buildRobotTorso();

	public void buildRobotArms();

	public void buildRobotLegs();
	
	public Robot getRobot();

}
