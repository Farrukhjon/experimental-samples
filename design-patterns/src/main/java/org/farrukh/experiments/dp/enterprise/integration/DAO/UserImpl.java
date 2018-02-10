package org.farrukh.experiments.dp.enterprise.integration.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImpl implements UserService {

	Connection			connection			= null;
	PreparedStatement	preparedStatement	= null;
	ResultSet			resultSet			= null;

	@Override
	public void add(User user) throws SQLException {
		String insertUser = "insert into user(firstName, name, patronymic, age, course) values(?, ?, ?, ?, ?)";
		preparedStatement = ConnectionFactory.getInstance().getConnection().prepareStatement(insertUser);
		preparedStatement.setString(1, user.getFirstName());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setString(3, user.getPatrpnymic());
		preparedStatement.setInt(4, user.getAge());
		preparedStatement.setString(5, user.getCourse());
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}

	@Override
	public void delete(User user) throws SQLException {
		String deleteUser = "delete from user where id = ?";
		preparedStatement = ConnectionFactory.getInstance().getConnection().prepareStatement(deleteUser);
		preparedStatement.setInt(1, user.getId());
		preparedStatement.close();
	}

	@Override
	public void update(User user) throws SQLException {
		String updateUser = "update user set course = ? where id = 1";
		preparedStatement = ConnectionFactory.getInstance().getConnection().prepareStatement(updateUser);
		preparedStatement.setString(1, user.getCourse());
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
}
