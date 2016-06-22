package org.farrukh.examples.patterns.behavioral.command.ch1;

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
