package org.farrukh.examples.patterns.creational.abstractFactories.ch1;

/**
 * Description of AbstractFactory.
 */
public abstract class AbstractFactory implements IFactory {

	public AbstractFactory() {
		super();
	}

	public IProduct createProductA() {
		IProduct createProductA = null;
		return createProductA;
	}

	public IProduct createProductB() {
		IProduct createProductB = null;
		return createProductB;
	}

}
