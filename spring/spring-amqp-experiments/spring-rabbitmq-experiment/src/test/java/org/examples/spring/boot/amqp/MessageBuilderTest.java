/**
 * 
 */
package org.examples.spring.boot.amqp;

import java.io.IOException;
import java.util.UUID;

import org.examples.spring.boot.amqp.dto.Product;
import org.junit.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.MessagePropertiesBuilder;
import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class MessageBuilderTest extends BaseJUnitTest {
	
	private static final String data = "This data from testSimpleMessageBuilder";
	private static final String jsonData = "";
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void testSimpleTextMessageBuilder(){
		MessageProperties properties = MessagePropertiesBuilder.newInstance()
				.setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
				.setMessageId(UUID.randomUUID().toString())
				.setCorrelationId(UUID.randomUUID().toString().getBytes())
				.build();
		Message message = MessageBuilder.withBody(data.getBytes()).andProperties(properties).build();
		Message result = rabbitTemplate.sendAndReceive("app.example.queue", message);
		Assert.notNull(result);
	}
	
	@Test
	public void testSimpleJSONMessageBuilder() throws JsonGenerationException, JsonMappingException, IOException{
		
		Product product = new Product(1, "computer");
		String jsonData = mapper.writeValueAsString(product);
		System.out.println(jsonData);
		MessageProperties properties = MessagePropertiesBuilder.newInstance()
				.setContentType(MessageProperties.CONTENT_TYPE_JSON)
				.setMessageId(UUID.randomUUID().toString())
				.setCorrelationId(UUID.randomUUID().toString().getBytes())
				.build();
		Message message = MessageBuilder.withBody(jsonData.getBytes()).andProperties(properties).build();
		Message result = rabbitTemplate.sendAndReceive("app.example.queue", message);
		Assert.notNull(result);
	}

}
