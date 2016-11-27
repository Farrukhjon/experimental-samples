/**
 * 
 */
package org.examples.spring.boot.amqp;

import org.junit.Test;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class MessageListenerTest extends BaseJUnitTest {

	@Autowired
	MessageListener messageListener;

	@Test
	public void testMessageListener() {
		Assert.notNull(messageListener);
	}

}
