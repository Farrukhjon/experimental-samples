package org.farrukh.experiments.dp.creational.factoryMethod.ch1;

public class SecureOracleConnection extends Connection {
	
	public SecureOracleConnection() {

	}
	
	@Override
	public String description() {
		return "Oracle secure";
	}

}
