package org.farrukh.examples.patterns.creational.factoryMethod.ch1;

public class SecureOracleConnection extends Connection {
	
	public SecureOracleConnection() {

	}
	
	@Override
	public String description() {
		return "Oracle secure";
	}

}
