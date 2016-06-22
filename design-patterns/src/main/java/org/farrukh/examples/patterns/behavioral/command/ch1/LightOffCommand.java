package org.farrukh.examples.patterns.behavioral.command.ch1;

/**
 * @author Farrukhjon SATTOROV
 */
public class LightOffCommand implements ICommand {

	private Light	light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.switchOff();
	}
}
