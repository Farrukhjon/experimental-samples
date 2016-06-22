package org.farrukh.examples.spring.core.container.configuration.applicationContext.annotation.component;

import org.farrukh.examples.spring.core.container.dto.User;
import org.springframework.stereotype.Component;

/**
 * Created by Farrukhjon SATTOROV.
 */
@Component
public class UserBuilder implements Builder<User> {

    @Override
    public User build() {
        User user = new User();
        user.setName("Ali");
        return user;
    }
}
