/**
 * 
 */
package org.examples.spring.rest.test

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*

import org.examples.spring.rest.Application;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext

import spock.lang.Specification

/**
 * @author Farrukhjon SATTOROV
 *
 */

@ContextConfiguration(loader = SpringApplicationContextLoader, classes = Application)
class BaseRestIntegrationTest extends Specification {
}
