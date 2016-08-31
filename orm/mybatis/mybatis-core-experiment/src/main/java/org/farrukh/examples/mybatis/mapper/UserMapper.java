package org.farrukh.examples.mybatis.mapper;

import org.farrukh.examples.mybatis.domain.User;

/**
 * Created by Farrukhjon on 25-Sep-15.
 */
public interface UserMapper {

    public User selectUserById(int id);
}
