/**
 * 
 */
package org.examples.mybatis.hsqldb.factory;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.examples.mybatis.hsqldb.dto.Product;
import org.hsqldb.jdbc.JDBCDataSourceFactory;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class JavaSqlSessionFactory {

	private static JavaSqlSessionFactory instance;

	public static final JavaSqlSessionFactory getInstance() {
		return instance != null ? instance : (instance = new JavaSqlSessionFactory());
	}

	private SqlSessionFactory sqlSessionFactory;

	private JavaSqlSessionFactory() {

		DataSource dataSource = null;
		try {
			dataSource = JDBCDataSourceFactory.createDataSource(loadProperties());
		} catch (Exception e) {
			e.printStackTrace();
		}
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(Product.class);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
	}

	public SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}

	private Properties loadProperties() {
		Properties props = new Properties();
		return props;
	}
}
