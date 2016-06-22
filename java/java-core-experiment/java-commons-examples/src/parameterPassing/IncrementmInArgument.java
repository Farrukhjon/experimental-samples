package parameterPassing;

public class IncrementmInArgument {

	public static void main(String[] args) {

		int i = 0;
		int result = increment(i++, i); // increment(0, 0 + 1)
		System.out.println(result);

		int j = 0;
		int result2 = increment(++j, j); // increment(1, 1)
		System.out.println(result2);

		leftToRight(-1 > 0, true);
		leftToRight(-1 < 0, true);
		int q = 10;
		int k = q = 2; // k = (q = 2) <=> k = 2
		System.out.println("k = " + k);

	}

	private static int increment(int a, int b) {
		return a + b;
	}

	private static void leftToRight(boolean a, boolean b) {
		if (a && b)
			System.out.println("success left to right");
	}

}
