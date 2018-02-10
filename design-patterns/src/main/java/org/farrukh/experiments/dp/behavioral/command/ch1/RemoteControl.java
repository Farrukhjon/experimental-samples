package org.farrukh.experiments.dp.behavioral.command.ch1;

//Invoker class
/**
 * @author Farrukhjon SATTOROV
 */
public class RemoteControl {

	private ICommand	command;

	public void pressButton() {
		command.execute();
	}

	public void setCommand(ICommand command) {
		this.command = command;
	}
}
