package org.farrukh.example.service;

import org.farrukh.example.domain.User;
import org.farrukh.example.domain.UserDTO;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserDTO userDTO);

}
