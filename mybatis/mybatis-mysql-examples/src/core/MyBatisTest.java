package core;

import java.util.List;

import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import orm.PersonMapper;

import dto.Address;
import dto.Person;

import session.SqlSessionBuilder;

public class MyBatisTest {

	public static void main(String[] args) {
		LogFactory.useLog4JLogging();
		SqlSession session = SqlSessionBuilder.getInstance().getSqlSession();

		Address address = new Address();
		address.setCity("Dushanbe");
		address.setEmail("hello@gmail.com");
		address.setHomePhone("123465789");
		address.setMobilePhone("987654321");
		address.setProvince("Khistevarz");
		address.setRegion("Sogd");
		address.setStreet("Saadi Sherozi 123");
		address.setWorkPhone("132465789");
		
		session.insert("insertAddress", address);
		
		Person person = new Person();

		person.setSurname("Aliev");
		person.setName("Vali");
		person.setPatronymic("Samievuch");
		person.setAge(27);
		person.setAddress(address);

		session.insert("insertPerson", person);
		session.commit();

		List<Person> result = session.selectList("selectAllPerson");
		/*for (Person u : result) {
			System.out.printf("%-10s", u.getSurname());
			System.out.printf("%-10s", u.getName());
			System.out.printf("%-10s", u.getPatronymic());
			System.out.printf("%-10d", u.getAge());
			System.out.println();
		}*/

	/*	List<Person> result1 = session.selectList("selectPersonByTwoParam", person);
		for (Person s : result1) {
			System.out.println(s.getName());
		}*/

		PersonMapper mep = session.getMapper(PersonMapper.class);
		List<String> m = mep.getName("Aliev", 27);
		/*for (String s : m) {
			System.out.println(s);
		}*/
		List<Integer> age = mep.getAge("Aliev");
		/*for (Integer a : age) {
			System.out.println(a);
		}*/
		//session.delete("deleteAllPerson");
		session.commit();

		session.close();
	}
}
