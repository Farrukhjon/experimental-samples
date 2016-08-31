package org.examples.rabbitmq.simple;

/**
 * Hello world!
 *
 */
public class SenderReceiverDemo {

	public static void main(String[] args) {
		new Sender("My message");
		new Receiver();
	}
}
