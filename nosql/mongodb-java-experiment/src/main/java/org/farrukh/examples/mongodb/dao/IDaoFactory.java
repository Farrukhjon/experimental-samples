package org.farrukh.examples.mongodb.dao;

/**
 * @author Farrukh SATTOROV 
 * */

public interface IDaoFactory {

	public UserDao getUserDao();

	public PersonDao getPersonDao();

}
