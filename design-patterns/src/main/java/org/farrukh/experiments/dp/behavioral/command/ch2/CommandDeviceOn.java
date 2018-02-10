package org.farrukh.experiments.dp.behavioral.command.ch2;

public class CommandDeviceOn implements ICommand {

	private IElectronicDevice	device;

	public CommandDeviceOn(IElectronicDevice device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.on();
	}
}
