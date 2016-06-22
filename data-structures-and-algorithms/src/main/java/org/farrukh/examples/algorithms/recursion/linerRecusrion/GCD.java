package recursion.linerRecusrion;

public class GCD {

	public static void main(String[] args) {
		long gcd = Euclid(10, 5);
		System.out.println(gcd);
	}

	public static long Euclid(int a, int b) {
		return (b == 0) ? a : Euclid(b, a % b);
	}

}
