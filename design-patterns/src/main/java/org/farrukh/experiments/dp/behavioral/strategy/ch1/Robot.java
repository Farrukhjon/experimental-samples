package org.farrukh.experiments.dp.behavioral.strategy.ch1;

/**
 * @author Farrukhjon SATTOROV
 */
public class Robot {

	private IBehavior	startegy;
	private String		name;

	public Robot(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public IBehavior getStartegy() {
		return startegy;
	}

	public void move() {
		System.out.print(this.name + " ");
		int command = startegy.moveCommand();
		System.out.println(this.name + " " + String.valueOf(command));
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStartegy(IBehavior startegy) {
		this.startegy = startegy;
	}
}
