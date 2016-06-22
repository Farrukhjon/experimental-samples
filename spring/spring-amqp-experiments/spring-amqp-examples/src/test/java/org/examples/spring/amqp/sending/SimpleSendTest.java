/**
 * 
 */
package org.examples.spring.amqp.sending;

import org.examples.spring.amqp.BaseJUnitTest;
import org.examples.spring.amqp.pojo.ProductRequest;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class SimpleSendTest extends BaseJUnitTest {

	@Test
	public void testSimpleSendJsonMessage() throws JsonProcessingException {
		RabbitTemplate template = getContext().getBean(RabbitTemplate.class);
		ProductRequest productRequest = new ProductRequest(1, "get-products", "application/json");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(productRequest);
		System.out.println(json);
		String response =  (String) template.convertSendAndReceive("hello");
		assertNotNull(response);
	}

}
