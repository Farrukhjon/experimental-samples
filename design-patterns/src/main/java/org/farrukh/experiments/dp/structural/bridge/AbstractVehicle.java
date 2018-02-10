package org.farrukh.experiments.dp.structural.bridge;

/**
 * abstraction in bridge pattern
 */

public abstract class AbstractVehicle {

	protected IWorkshop	workshop1;
	protected IWorkshop	workshop2;

	public AbstractVehicle(IWorkshop workshop1, IWorkshop workshop2) {
		this.workshop1 = workshop1;
		this.workshop2 = workshop2;
	}

	abstract public void manufacture();
}
