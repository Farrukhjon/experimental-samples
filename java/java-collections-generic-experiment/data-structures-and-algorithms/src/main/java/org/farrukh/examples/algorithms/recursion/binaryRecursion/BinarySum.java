package recursion.binaryRecursion;

public class BinarySum {

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7 };
		int value = binarySum(a, 0, a.length - 1);
		System.out.println(value);
	}

	private static int binarySum(int[] a, int i, int n) {
		if (n == 1)
			return a[i];
		return binarySum(a, i, n / 2) + binarySum(a, i + (n / 2), n / 2);

	}

}
