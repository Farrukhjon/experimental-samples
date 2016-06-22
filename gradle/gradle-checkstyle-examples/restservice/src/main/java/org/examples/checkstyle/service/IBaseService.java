/**
 * 
 */
package org.examples.checkstyle.service;

import java.io.Serializable;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public interface IBaseService<T extends Serializable> {

	public T findById(int id);

	public int save(T instance);

	public int update(T instance);

	public void delete(T instance);

}
