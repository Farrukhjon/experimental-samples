package org.examples.rabbitmq.simple;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

public class Receiver {

	private static final String queue_name = "hello";

	public Receiver() {
		Connection connection = null;
		Channel channel = null;
		try {
			ConnectionFactory factory = new ConnectionFactory();
			connection = factory.newConnection();
			channel = connection.createChannel();
			channel.queueDeclare(queue_name, false, false, false, null);
			System.out.println("Waiting for messages...");

			QueueingConsumer consumer = new QueueingConsumer(channel);
			channel.basicConsume(queue_name, false, consumer);
			while (true) {
				QueueingConsumer.Delivery delivery = consumer.nextDelivery();
				System.out.println(new String(delivery.getBody()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ShutdownSignalException e) {
			e.printStackTrace();
		} catch (ConsumerCancelledException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				channel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
