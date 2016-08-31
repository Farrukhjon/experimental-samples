package core;

import java.util.Arrays;
import java.util.List;

import business.Service;
import dao.UserDao;
import dto.Person;
import dto.User;

public class TestUser {
	
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();
		List<User> users = Arrays.asList(new User[]{new User("login1", "password1", person1, "admin"),
				new User("login2", "password2", person2, "admin"),
				new User("login3", "password3", person3, "admin")});
		UserDao userDao = (UserDao) Service.createDao(UserDao.class);
		userDao.insert(users);
		
	}
}
