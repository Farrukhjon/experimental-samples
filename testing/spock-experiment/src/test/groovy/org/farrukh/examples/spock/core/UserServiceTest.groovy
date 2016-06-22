/**
 * 
 */
package org.farrukh.examples.spock.core

import org.farrukh.examples.spock.core.dto.User
import org.farrukh.examples.spock.core.service.UserService

import spock.lang.Specification

/**
 * @author Farrukhjon SATTOROV
 *
 */
class UserServiceTest extends Specification {

	def 'define users count'() {

		setup: 'creating user service with two users'
		List<User> users = new ArrayList<>()
		users.add(new User())
		users.add(new User())
		UserService service = new UserService(users)

		expect: 'Invoke count method'
		2 == service.count()
	}

	def 'Return total number of users'() {

		setup: 'Create UserService instance with users'
		def userService = new UserService(users: users)

		expect: 'Invoke count() method'
		expectedCount == userService.count()

		where:
		expectedCount | users
					0 | null
					0 | []
					1 | ['ali']
					2 | ['ali', 'vali']
	}
}
