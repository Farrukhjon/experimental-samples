/**
 * 
 */
package org.examples.rabbitmq.message;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import com.rabbitmq.client.AMQP.BasicProperties;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class MessagePropertiesDemo {

	private static String appId = "rabbitmq-examples";
	private static String contentEncoding="utf-8";
	private static String contentType = "text/plain";
	private static String correlationId = UUID.randomUUID().toString();
	private static Integer deliveryMode = 1;
	private static String messageId = "message-"+UUID.randomUUID().toString();
	private static String replyTo = "sender.queue.name";
	private static Date timestamp = new Timestamp(new Date().getTime());
	private static String type = "hello-message";

	public static void main(String[] args) {
		BasicProperties messageProp = new BasicProperties
										.Builder()
										.appId(appId)
										.contentEncoding(contentEncoding)
										.contentType(contentType)
										.correlationId(correlationId)
										.deliveryMode(deliveryMode )
										.messageId(messageId )
										.replyTo(replyTo )
										.timestamp(timestamp )
										.type(type )
										.build();
		System.out.println(messageProp);		
	}

}
