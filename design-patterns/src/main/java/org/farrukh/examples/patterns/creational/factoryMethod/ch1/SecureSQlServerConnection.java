package org.farrukh.examples.patterns.creational.factoryMethod.ch1;

public class SecureSQlServerConnection extends Connection {

	public SecureSQlServerConnection() {
	}
	
	@Override
	public String description() {
		return "SQL Server secure";
	}

}
