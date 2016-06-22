package string;

public class HasLowerCase {

	public static void main(String[] args) {
		if ("dsd".matches("(?i)[a-z]+"))
			System.out.println("case insentative");
	}

	@SuppressWarnings("unused")
	private static boolean isLower(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLowerCase(s.charAt(i)))
				return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	private static boolean isUpper(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i)))
				return true;
		}
		return false;
	}

}
