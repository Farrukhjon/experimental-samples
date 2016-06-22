package org.farrukh.examples.spring.security.jpa.repository;

import org.farrukh.examples.spring.security.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
