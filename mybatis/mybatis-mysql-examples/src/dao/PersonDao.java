package dao;

import business.Service;
import dto.Person;

public class PersonDao extends AbstractBaseDao<Person> {

	public PersonDao() {
		super(Person.class);
	}

	public AddressDao getAddressDao() {
		AddressDao addressDao = (AddressDao) Service.createDao(AddressDao.class); 
		return addressDao;
	}

}
