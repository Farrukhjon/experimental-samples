package org.farrukh.examples.patterns.creational.abstractFactories.ch1;

/**
 * Description of Client.
 */
public class Client {

	public IFactory	abstarctFactory	= null;

	public IProduct	abstarctProduct	= null;

	public Client() {
		super();
	}

	public IFactory getAbstarctFactory() {
		return this.abstarctFactory;
	}

	public IProduct getAbstarctProduct() {
		return this.abstarctProduct;
	}

	public void setAbstarctFactory(IFactory newAbstarctFactory) {
		this.abstarctFactory = newAbstarctFactory;
	}

	public void setAbstarctProduct(IProduct newAbstarctProduct) {
		this.abstarctProduct = newAbstarctProduct;
	}
}
