/**
 * 
 */
package org.examples.spring.boot.amqp;

import org.examples.spring.boot.amqp.dto.Product;
import org.junit.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.JsonMessageConverter;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ToMessageConverterTest extends BaseJUnitTest {

	@Test
	public void testToMessageConverter() {
		Product product = new Product(1, "smart phone");
		JsonMessageConverter converter = new JsonMessageConverter();
		MessageProperties prop = new MessageProperties();
		Message message = converter.toMessage(product, prop);
		rabbitTemplate.setMessageConverter(converter);
		rabbitTemplate.send(message);
	}

}
