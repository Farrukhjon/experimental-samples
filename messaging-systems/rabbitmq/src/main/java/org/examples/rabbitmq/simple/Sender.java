package org.examples.rabbitmq.simple;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Sender {

	private static final String queue_name = "hello";

	public Sender(String message) {
		Connection connection = null;
		Channel channel = null;
		try {
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			connection = factory.newConnection();
			channel = connection.createChannel();
			channel.queueDeclare(queue_name, false, false, false, null);
			channel.basicPublish("", queue_name, null, message.getBytes());
			System.out.println("[x] sent '" + message + "'");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
