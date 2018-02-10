package org.farrukh.experiments.dp.structural.decorator.ch1;

public abstract class IceCreamDecorator implements IIceCream {

	protected IIceCream	specialIceCream;

	public IceCreamDecorator(IIceCream specialIceCream) {
		this.specialIceCream = specialIceCream;
	}

	@Override
	public String makeIceCream() {
		return specialIceCream.makeIceCream();
	}
}
