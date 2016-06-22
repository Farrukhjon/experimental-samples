package core;
import business.Service;
import dao.AddressDao;
import dao.UserDao;
import dto.Address;
import dto.Person;
import dto.User;

public class Demo {

	public static void main(String[] args) {
		UserDao userDao = (UserDao) Service.createDao(UserDao.class);
		
		
		Address address = new Address();
		address.setCity("Dushanbe");
		address.setRegion("Central");
		address.setStreet("street1");
		AddressDao addressDao = (AddressDao) Service.createDao(AddressDao.class);
		addressDao.insert(address);
		
		Person person = new Person();
		person.setName("name1");
		person.setSurname("surname1");
		person.setPatronymic("patronymic1");
		person.setAddress(address);
		userDao.getPersonDao().insert(person);
		
		User user = new User();
		user.setLogin("login1");
		user.setPassword("password1");
		user.setAuthority("authority1");
		user.setPerson(person);
		userDao.insert(user);
		user = userDao.selectById(1l);
		System.out.println(user);
		
		/*		AddressDao addressDao = (AddressDao) Service.createDao(AddressDao.class);
		List<Address> address = addressDao.selectAllBy("city");
		for (Address a : address) {
			System.out.println(a.getCity());
		}
*/
		/*SqlSession session = SqlSessionBuilder.getInstance().getSqlSession();
		PersonMapper<Address> mep = session.getMapper(PersonMapper.class);
		List<Address> cities = mep.getByParam("city", "address");
		for (Address a : cities) {
			System.out.println(a.getCity());
		}
		PersonMapper<Person> m = session.getMapper(PersonMapper.class);
		List<Person> p = m.getByParam("name", "person");
		for (Person a : p) {
			System.out.println(a.getName());
		}*/
	}

}
