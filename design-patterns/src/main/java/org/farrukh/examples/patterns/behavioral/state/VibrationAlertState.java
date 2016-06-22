package org.farrukh.examples.patterns.behavioral.state;

public class VibrationAlertState implements IMobileAlertState {

	@Override
	public void alert(AlertStateContext context) {
		System.out.println(context.getVibration());
	}
	
	

}
