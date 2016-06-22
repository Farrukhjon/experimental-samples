package enums;

public class EnumDemo {

	private enum Session {
		WINTER, SPRING, SUMMER, AUTUMN
	}

	public static void main(String[] args) {
		for (Session s : Session.values()) {
			System.out.println(s);
		}
	}

}
