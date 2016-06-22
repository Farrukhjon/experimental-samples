package org.farrukh.examples.patterns.behavioral.state;

public class AlertStateContext {

	private String				silent		= "silent...";
	private String				vibration	= "vibration...";

	private IMobileAlertState	alertState;

	public AlertStateContext() {
		alertState = new VibrationAlertState();
	}

	public void setAlertState(IMobileAlertState state) {
		this.alertState = state;
	}

	public void alert() {
		alertState.alert(this);
	}

	public String getSilent() {
		return silent;
	}

	public String getVibration() {
		return vibration;
	}

}
