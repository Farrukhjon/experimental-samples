package string;

public class SplitStringIntoWordsWithRegex {

	public static void main(String[] args) {

		String str = "Hello,java,world!";

		for (String s : str.split(",")) {
			System.out.println(s);
		}
	}
}
