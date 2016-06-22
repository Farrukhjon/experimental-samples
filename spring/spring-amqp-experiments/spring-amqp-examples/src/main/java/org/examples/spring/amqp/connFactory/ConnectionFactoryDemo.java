/**
 * 
 */
package org.examples.spring.amqp.connFactory;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ConnectionFactoryDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConnectionFactory connection = new CachingConnectionFactory();
		AmqpAdmin amqpAdmin = new RabbitAdmin(connection);
		
	}

}
