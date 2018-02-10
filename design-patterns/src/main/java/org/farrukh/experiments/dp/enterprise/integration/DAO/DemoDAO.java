package org.farrukh.experiments.dp.enterprise.integration.DAO;

import java.sql.SQLException;

public class DemoDAO {

	public static void main(String[] args) throws SQLException {

		User user = new User();
		user.setFirstName("Den");
		user.setName("Baba");
		user.setPatrpnymic("Yamamoto");
		user.setAge(23);
		user.setCourse("Math");

		UserImpl impl = new UserImpl();
		impl.add(user);

	}
}
