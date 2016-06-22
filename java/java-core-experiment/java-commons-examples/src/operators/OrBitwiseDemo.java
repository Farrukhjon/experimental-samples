package operators;

public class OrBitwiseDemo {

	public static void main(String[] args) {

		boolean a = true;
		boolean b = false;
		boolean c;
		c = a | b;
		print(c);
		c = false;
		c |= b;
		print(c);
	}

	private static void print(boolean x) {
		System.out.println(x);
	}

}
