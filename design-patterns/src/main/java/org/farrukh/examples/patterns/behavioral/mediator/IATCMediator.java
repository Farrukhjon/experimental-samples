package org.farrukh.examples.patterns.behavioral.mediator;

public interface IATCMediator {

	public boolean isLandingOk();

	public void registerFlight(Flight flight);

	public void registerRunway(Runway runway);

	public void setLandingStatus(boolean status);
}
