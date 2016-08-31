package dao;

import business.Service;
import dto.User;

public class UserDao extends AbstractBaseDao<User> {

	public UserDao() {
		super(User.class);
	}

	public PersonDao getPersonDao() {
		PersonDao personDao = (PersonDao) Service.createDao(PersonDao.class);
		return personDao;
	}
}
