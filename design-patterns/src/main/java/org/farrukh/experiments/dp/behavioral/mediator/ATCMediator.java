package org.farrukh.experiments.dp.behavioral.mediator;

/**
 * @author Farrukhjon SATTOROV
 */
public class ATCMediator implements IATCMediator {

	private Flight	flight;
	private Runway	runway;
	public boolean	land;

	public boolean isLandingOk() {
		return land;
	}

	public void registerFlight(Flight flight) {
		this.flight = flight;
	}

	public void registerRunway(Runway runway) {
		this.runway = runway;
	}

	public void setLandingStatus(boolean status) {
		land = status;
	}

	public Flight getFlight() {
		return flight;
	}

	public Runway getRunway() {
		return runway;
	}

	public boolean isLand() {
		return land;
	}
}
