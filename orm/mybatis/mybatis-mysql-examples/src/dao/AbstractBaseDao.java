package dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import session.SqlSessionBuilder;

/**
 * @author Farrukhjon SATTOROV
 * 
 * @param <T>
 */
public abstract class AbstractBaseDao<T extends Serializable> implements IBaseDao<T> {

	private Class<T>			domainClass;
	protected SqlSession		sqlSession;

	public static final String	selectQuery	= "select";
	public static final String	insertQuery	= "insert";
	public static final String	updateQuery	= "update";
	public static final String	deleteQuery	= "delete";

	public AbstractBaseDao(Class<T> domainClass) {
		this.domainClass = domainClass;
		sqlSession = SqlSessionBuilder.getInstance().getSqlSession();
	}

	@Override
	public T selectById(Long id) {
		String statement = selectQuery + domainClass.getSimpleName() + "ById";
		final T Type = sqlSession.selectOne(statement, id);
		sqlSession.close();
		return Type;
	}

	@Override
	public T selectBy(String parameter) {
		String statement = selectQuery + domainClass.getSimpleName() + "By" + parameter;
		final T Type = sqlSession.selectOne(statement, parameter);
		sqlSession.close();
		return Type;
	}

	@Override
	public List<T> selectAll() {
		String statement = selectQuery + "All" + domainClass.getSimpleName();
		final List<T> Types = sqlSession.selectList(statement);
		sqlSession.close();
		return Types;
	}

	@Override
	public List<T> selectAllBy(String parameter) {
		String statement = selectQuery + "All" + domainClass.getSimpleName() + "By";
		final List<T> Types = sqlSession.selectList(statement, parameter);
		sqlSession.close();
		return Types;
	}

	@Override
	public List<T> selectRange(long first, long count) {
		String statement = selectQuery + "Range" + domainClass.getSimpleName();
		final List<T> Types = (List) sqlSession.selectList(statement).subList((int) first, (int) (first + count));
		sqlSession.close();
		return Types;
	}

	@Override
	public void insert(T instance) {
		String statement = insertQuery + domainClass.getSimpleName();
		sqlSession.insert(statement, instance);
		sqlSession.close();
	}

	@Override
	public void insert(List<T> instance) {
		String statement = insertQuery +"All"+ domainClass.getSimpleName();
		//for (T in : instance) {
			sqlSession.insert(statement, instance);
		//}
	}

	@Override
	public void update(T instance) {
		String statement = updateQuery + domainClass.getSimpleName();
		sqlSession.update(statement, instance);
	}

	@Override
	public void update(List<T> instance) {
		String statement = updateQuery + domainClass.getSimpleName();
		for (T in : instance) {
			sqlSession.update(statement, in);
		}
	}

	@Override
	public void delete(T instance) {
		String statement = deleteQuery + domainClass.getSimpleName();
		sqlSession.delete(statement, instance);
	}

	@Override
	public void delete(T instance, String parameter) {
		String statement = deleteQuery + domainClass.getSimpleName();
		sqlSession.delete(statement, parameter);
	}

}
