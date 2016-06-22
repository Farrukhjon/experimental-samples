/**
 * 
 */
package org.farrukh.examples.spock.core

import org.farrukh.examples.spock.core.service.UserController;

import spock.lang.Specification;

/**
 * @author Farrukhjon SATTOROV
 *
 */
class UserControllerTest extends Specification{

	def 'testing user controller'(){
		given:
		def controller = new UserController();
		
		when:
		controller.getUserCount() <0
		
		then:
		println 'user count <=0'
	}
}
