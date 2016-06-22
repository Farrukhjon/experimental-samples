package bit;

public class BitwiseOpersBasicDemo {

	public static void main(String[] args) {

		int a = 0xfff;
		System.out.println(a);
		int b = 64;
		int c = a & b;
		System.out.printf("%-5s %-5s %-5s", Integer.toString(a, 2), Integer.toString(b, 2), Integer.toString(c, 16));

		int d = a | b;
		System.out.println(d);

		int e = a ^ b;
		System.out.println(e);

	}

}
