package org.farrukh.examples.patterns.behavioral.command.ch1;

/**
 * @author Farrukhjon SATTOROV
 */
public class LightOnCommand implements ICommand {

	private Light	light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.switchOn();
	}
}
