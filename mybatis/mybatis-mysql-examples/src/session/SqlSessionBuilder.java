package session;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import orm.PersonMapper;



public class SqlSessionBuilder {

	private static SqlSessionBuilder	instance;
	private SqlSessionFactory			sqlSessionFactory;

	public SqlSessionBuilder() {
		Reader readerConfigFile = null;
		try {
			readerConfigFile = Resources.getResourceAsReader("resources/MyBatisConfiguration.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(readerConfigFile);
		sqlSessionFactory.getConfiguration().addMapper(PersonMapper.class);
	}

	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

	public static SqlSessionBuilder getInstance() {
		return (instance == null) ? instance = new SqlSessionBuilder() : instance;
	}
}
