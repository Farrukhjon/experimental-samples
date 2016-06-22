package components.JTbale;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int					id;
	private String				surname;
	private String				name;
	private String				login;
	private String				password;

	private List<User>			users;
	private List<List<User>>	usersData;

	public User() {
		users = new ArrayList<User>();
		usersData = new ArrayList<List<User>>();
		users.add(new User(1, "Aliev", "Vali", "ali", "pass1"));
		usersData.add(users);
		users.add(new User(2, "Toshev", "Sami", "sami", "pass2"));
		usersData.add(users);
		users.add(new User(3, "Qoshev", "Kosa", "kosa", "pass3"));
		usersData.add(users);
		users.add(new User(4, "Moshev", "Tabar", "test", "pass4"));
		usersData.add(users);
		users.add(new User(5, "Sangov", "Tesha", "logTesha", "pass5"));
		usersData.add(users);
	}

	public User(int id, String surname, String name, String login, String password) {
		super();
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<User> getUsers() {
		return users;
	}

	public List<List<User>> getUsersData() {
		return usersData;
	}

	private String getUser() {
		return String.valueOf(id) + " " + surname + " " + name + " " + login + " " + password;
	}

	@Override
	public String toString() {
		return "[" + getUser() + "]";
	}
}
