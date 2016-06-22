package string;

public class Person {

	private String	surname;
	private String	name;
	private String	patronimyc;

	public Person(String surname, String name, String patronimyc) {
		this.surname = surname;
		this.name = name;
		this.patronimyc = patronimyc;
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

	public String getPatronimyc() {
		return patronimyc;
	}

	public void setPatronimyc(String patronimyc) {
		this.patronimyc = patronimyc;
	}

	@Override
	public String toString() {
		return "Person [surname=" + surname + ", name=" + name + ", patronimyc=" + patronimyc + "]";
	}

}
