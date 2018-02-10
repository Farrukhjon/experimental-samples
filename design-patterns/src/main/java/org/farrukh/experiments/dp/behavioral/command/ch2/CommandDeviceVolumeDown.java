package org.farrukh.experiments.dp.behavioral.command.ch2;

public class CommandDeviceVolumeDown implements ICommand {

	private IElectronicDevice	device;

	public CommandDeviceVolumeDown(IElectronicDevice device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.volumeDown();
	}

}
