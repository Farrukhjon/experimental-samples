package string;

public class EqualsTest {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = s1;
		String s3 = new String("abc");
		String s4 = new String("abc");
		String s5 = "abc";

		System.out.println("s1 == s5 comparison : " + (s1 == s5));
		System.out.println("s1 == s2 comparison : " + (s1 == s2));
		System.out.println("s1.equals(s2), using equals method : " + s1.equals(s2));
		System.out.println("s3 == s4 comparison : " + (s3 == s4));
		System.out.println("s3.equals(s4), using equals method : " + s3.equals(s4));

		final String one = "One";
		boolean isEqual = one.equals(new String("One"));
		System.out.println("one.equal(new String('One'): " + isEqual);

		boolean isSame = (one == new String("One"));
		System.out.println("one == new String('One'): " + isSame);
	}

}
