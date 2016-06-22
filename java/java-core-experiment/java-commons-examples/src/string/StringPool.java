package string;

public class StringPool {

	public static void main(String[] args) {

		String str1 = "Ball";
		String str2 = "Ball";

		String str3 = new String("Ball");

		System.out.println(str1 == str2); // is the same pointer, yes
		System.out.println(str1 == str3); // is the same pointer, no
		System.out.println(str2 == str3); // is the same pointer, no
	}

}
