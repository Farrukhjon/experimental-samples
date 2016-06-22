package string;

public class CompareTwoStr {

	public static void main(String[] args) {
		String str = "str";
		String anotherString = "STR";

		int result = str.compareTo(anotherString);
		System.out.println(result);

		int resultIgnoreCase = str.compareToIgnoreCase(anotherString);
		System.out.println(resultIgnoreCase);
	}
}
