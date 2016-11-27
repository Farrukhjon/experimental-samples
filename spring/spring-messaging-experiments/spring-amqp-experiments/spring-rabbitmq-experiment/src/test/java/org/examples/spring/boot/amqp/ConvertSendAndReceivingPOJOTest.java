/**
 * 
 */
package org.examples.spring.boot.amqp;

import org.examples.spring.boot.amqp.dto.ProductRequest;
import org.examples.spring.boot.amqp.dto.ProductResponse;
import org.junit.Test;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class ConvertSendAndReceivingPOJOTest extends BaseJUnitTest {
	
	@Test
	public void testRecevingPOJO() {
		ProductRequest request = new ProductRequest("get-printer", 100.0);
		ProductResponse result = (ProductResponse) rabbitTemplate.convertSendAndReceive(EXCHANGE_NAME, QUEUE_NAME, request);
		assertNotNull(result);
	}

}
