package org.farrukh.experiments.dp.creational.factoryMethod.ch1;

public class Client {

	public static void main(String[] args) {

		SecureFactory factory = new SecureFactory();

		Connection connection = factory.createConnection("Oracle");

		Connection connection1 = factory.createConnection("SQL Server");

		Connection connection2 = factory.createConnection("");

		System.out.println("You are connectied with " + connection.description());

		System.out.println("You are connectied with " + connection1.description());

		System.out.println("You are connectied with " + connection2.description());

	}
}
