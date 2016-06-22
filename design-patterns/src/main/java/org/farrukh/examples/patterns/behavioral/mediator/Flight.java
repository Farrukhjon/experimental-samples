package org.farrukh.examples.patterns.behavioral.mediator;

/**
 * @author Farrukhjon SATTOROV
 */
public class Flight implements ICommand {

	private IATCMediator	atcMediator;

	public Flight(IATCMediator atcMediator) {
		this.atcMediator = atcMediator;
	}

	public void getReady() {
		System.out.println("Getting ready...");
	}

	public void land() {
		if (atcMediator.isLandingOk()) {
			System.out.println("Landing done....");
			atcMediator.setLandingStatus(true);
		} else
			System.out.println("Will wait to land....");
	}
}
