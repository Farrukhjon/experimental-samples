package dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Farrukhjon SATTOROV
 * 
 */
public class User implements Serializable {

	private long	idUser;
	private String	login;
	private String	password;
	private Person	person;
	private String	authority;
	
	public User() {
		this(null, null, null, null);
	}

	public User(String login, String password, Person person, String authority) {
		super();
		this.login = login;
		this.password = password;
		this.person = person;
		this.authority = authority;
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return login + " " + password;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

}
