package dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Farrukhjon SATTOROV
 * 
 * @param <T>
 *            Type of in or return param
 */
public interface IBaseDao<T extends Serializable> {

	public T selectById(Long id);

	public T selectBy(String parameter);

	public List<T> selectAll();

	public List<T> selectAllBy(String parameter);
	
	public List<T> selectRange(long first, long count);

	public void insert(T instance);

	public void insert(List<T> instance);

	public void update(T instance);

	public void update(List<T> instance);

	public void delete(T instance);

	public void delete(T instance, String parameter);

}
