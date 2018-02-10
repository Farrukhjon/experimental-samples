package org.farrukh.experiments.dp.creational.factoryMethod.ch1;

public class SecureSQlServerConnection extends Connection {

	public SecureSQlServerConnection() {
	}
	
	@Override
	public String description() {
		return "SQL Server secure";
	}

}
