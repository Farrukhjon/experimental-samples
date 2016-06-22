package string;

public class PassingByValue {

	private static String	str	= "Value 1";

	private static void changeIt(String s) {
		s = "Value 2";
	}

	public static void main(String[] args) {

		changeIt(str);
		System.out.println(str);
	}

}
