package org.farrukh.examples.patterns.creational.factoryMethod.ch1;

public abstract class ConnectionFactory {
	
	public ConnectionFactory() {
	}
	
	protected abstract Connection createConnection(String type);
}
