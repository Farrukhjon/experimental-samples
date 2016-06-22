/**
 * 
 */
package org.examples.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class Application {
	
	private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		new Application();
		logger.debug("Application has been created");
	}

}
