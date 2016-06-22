package org.farrukh.examples.mongodb.dao;

import java.util.List;
/**
 * @author Farrukh SATTOROV 
 * */
public interface IBaseDao<T> {

	public T selectById(int id);

	public List<T> selectAll();
	
	public void insert(T instance);

	public void update(T instance);
	
	public void delete(T instance);
	

}
