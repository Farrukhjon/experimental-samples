package org.farrukh.experiments.dp.behavioral.state;

public class VibrationAlertState implements IMobileAlertState {

	@Override
	public void alert(AlertStateContext context) {
		System.out.println(context.getVibration());
	}
	
	

}
