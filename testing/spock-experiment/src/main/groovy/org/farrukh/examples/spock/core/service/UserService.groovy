/**
 * 
 */
package org.farrukh.examples.spock.core.service

import org.farrukh.examples.spock.core.dto.User

/**
 * @author Farrukhjon SATTOROV
 *
 */
class UserService {

	List<User> users;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public UserService(List<User> users) {
		this.users = users;
	}

	public int count() {
		return users == null ? 0 : users.size();
	}
}
