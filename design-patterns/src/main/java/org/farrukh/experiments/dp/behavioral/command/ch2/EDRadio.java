package org.farrukh.experiments.dp.behavioral.command.ch2;

public class EDRadio implements IElectronicDevice {
	
	private int	volume	= 0;

	@Override
	public void on() {
		System.out.println("EDRadio is on");
	}

	@Override
	public void off() {
		System.out.println("EDRadio is off");
	}

	@Override
	public void volumeUp() {
		volume++;
		System.out.println("EDRadio volume up at " + volume);
	}

	@Override
	public void volumeDown() {
		volume--;
		System.out.println("EDRadio volume down at " + volume);
	}

}
