package org.farrukh.examples.patterns.behavioral.state;

public class Client {

	public static void main(String[] args) {

		AlertStateContext stateContext = new AlertStateContext();
		stateContext.alert();
		stateContext.alert();

		stateContext.setAlertState(new SilentAlertState());
		stateContext.alert();
		stateContext.alert();

		stateContext.setAlertState(new VibrationAlertState());
		stateContext.alert();
		stateContext.alert();
	}

}
