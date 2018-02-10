package org.farrukh.experiments.dp.creational.factoryMethod.ch1;

public class SQLServerConnection extends Connection {
	
	public SQLServerConnection() {
	}
	
	@Override
	public String description() {
		return "SQL Server";
	}

}
