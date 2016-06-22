package org.farrukh.examples.patterns.behavioral.command.ch2;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {

		IElectronicDevice tvDevice = new EDTelevision();

		IElectronicDevice radioDevice = new EDRadio();

		ICommand command = new CommandDeviceOn(tvDevice);

		DeviceButton onPressed = new DeviceButton(command);
		onPressed.press();

		command = new CommandDeviceOn(radioDevice);
		onPressed.setCommand(command);
		onPressed.press();

		command = new CommandDeviceVolumeUp(radioDevice);
		onPressed.setCommand(command);
		onPressed.press();
		onPressed.press();
		onPressed.press();

		command = new CommandDeviceVolumeDown(tvDevice);
		onPressed.setCommand(command);
		onPressed.press();
		onPressed.press();
		onPressed.press();

		List<IElectronicDevice> allDevice = new ArrayList<IElectronicDevice>();
		allDevice.add(tvDevice);
		allDevice.add(radioDevice);

		ICommand turnItAllOfCommand = new CommandTurnItAllOff(allDevice);

		onPressed.setCommand(turnItAllOfCommand);
		onPressed.press();

	}

}
