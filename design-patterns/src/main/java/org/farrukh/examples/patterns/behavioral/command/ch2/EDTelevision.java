package org.farrukh.examples.patterns.behavioral.command.ch2;

public class EDTelevision implements IElectronicDevice {

	private int	volume	= 0;

	@Override
	public void on() {
		System.out.println("TV is on");
	}

	@Override
	public void off() {
		System.out.println("TV is off");
	}

	@Override
	public void volumeUp() {
		volume++;
		System.out.println("TV volume up at " + volume);
	}

	@Override
	public void volumeDown() {
		volume--;
		System.out.println("TV volume down at " + volume);
	}

}
