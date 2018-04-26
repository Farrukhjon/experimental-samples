package recursion.linerRecusrion;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(factorial(10));
	}

	private static long factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
}
