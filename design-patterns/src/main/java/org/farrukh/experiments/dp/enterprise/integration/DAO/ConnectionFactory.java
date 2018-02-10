package org.farrukh.experiments.dp.enterprise.integration.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author    Farrukhjon SATTOROV
 */
public class ConnectionFactory {

	private String						driverClassName	= "com.mysql.jdbc.Driver";
	private String						connectionURL	= "jdbc:mysql//localhost:3306/user";
	private String						dbUserName		= "root";
	private String						dbPassword		= "myRoot007";

	/**
	 * @uml.property  name="instance"
	 * @uml.associationEnd  
	 */
	private static ConnectionFactory	instance		= null;

	/**
	 * @return
	 * @uml.property  name="instance"
	 */
	public static ConnectionFactory getInstance() {
		if (instance != null)
			instance = new ConnectionFactory();
		return instance;
	}

	private ConnectionFactory() {
		try {
			Class.forName(driverClassName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection(connectionURL, dbUserName, dbPassword);
		return connection;
	}
}
