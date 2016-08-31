package org.examples.rabbitmq.connection;

import java.io.IOException;

import com.rabbitmq.client.Address;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionFactoryDemo {

	private static ConnectionFactory factory;

	private ConnectionFactoryDemo() {

		String host = "rabbitmq";
		int port = 1234;
		String username = "root";
		String password = "p@ssw@rd";

		factory = new ConnectionFactory();
		factory.setHost(host);
		factory.setPort(port);
		factory.setUsername(username);
		factory.setPassword(password);

	}

	public static ConnectionFactory getInstance() {
		return (factory != null) ? factory : (factory = new ConnectionFactory());
	}

	public Connection getConnection() {
		Address[] address = { new Address("localhost", 123), new Address("localhost", 345), new Address("localhost", 678) };
		Connection connection = null;
		try {
			connection = getInstance().newConnection(address);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void main(String[] args) {
		ConnectionFactoryDemo.getInstance();
	}

}
