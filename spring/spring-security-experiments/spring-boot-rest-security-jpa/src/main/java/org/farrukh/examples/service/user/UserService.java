package org.farrukh.examples.service.user;

import org.farrukh.examples.domain.User;
import org.farrukh.examples.domain.UserDTO;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserDTO form);

}
