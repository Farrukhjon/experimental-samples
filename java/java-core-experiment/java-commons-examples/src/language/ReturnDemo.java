package language;

public class ReturnDemo {

	public static void main(String[] args) {
		new ReturnDemo().equals("HeLlO");
	}

	private void equals(String str) {
		if (!str.equalsIgnoreCase("hello")) {
			System.out.println("return");
			return;
		}
		System.out.println(str);
	}

}
