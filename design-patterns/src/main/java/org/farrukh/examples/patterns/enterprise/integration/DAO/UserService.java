package org.farrukh.examples.patterns.enterprise.integration.DAO;

import java.sql.SQLException;

public interface UserService {
	
	public void add(User user) throws SQLException;
	public void delete(User user) throws SQLException;
	public void update(User user) throws SQLException;

}
