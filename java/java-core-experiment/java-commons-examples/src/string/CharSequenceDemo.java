package string;

public class CharSequenceDemo {

	public static void main(String[] args) {

		CharSequence ch = "hello";
		System.out.println(ch);
		for (int i = ch.length() - 1; i >= 0; i--) {
			char c = ch.charAt(i);
			System.out.print(c);
		}
	}

}
