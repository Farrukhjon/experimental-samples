package org.farrukh.examples.patterns.creational.factoryMethod.ch1;

public class SecureMySQLConnection extends Connection {
	
	public SecureMySQLConnection() {
	}
	
	@Override
	public String description() {
		return "MySQL secure";
	}
	
}
