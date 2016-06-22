package string;

public class StringContainCharsequenceDemo {

	public static void main(String[] args) {

		CharSequence cs = "t";

		String str = "str";
		boolean contains = str.contains(cs);
		System.out.println(contains);
		contains = str.contains("a");
		System.out.println(contains);
	}

}
