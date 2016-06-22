package org.farrukh.examples.patterns.behavioral.command.ch2;

public class CommandDeviceOff implements ICommand {

	private IElectronicDevice	device;

	public CommandDeviceOff(IElectronicDevice device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.off();
	}

}
