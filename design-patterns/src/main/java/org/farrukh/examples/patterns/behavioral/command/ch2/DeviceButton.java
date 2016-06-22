package org.farrukh.examples.patterns.behavioral.command.ch2;

public class DeviceButton {

	private ICommand	command;

	public DeviceButton(ICommand command) {
		this.command = command;
	}

	public void press() {
		command.execute();
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}

}
