package language;

public class TernaryCondition {

	public static void main(String[] args) {
		System.out.println(ternary(0, 1, 2));

		System.out.println(ternary(0, 1, 0));

		System.out.println(ternary(1, 1, 0));

		System.out.println(ternary(1, 2, 0));
	}

	private static boolean ternary(int x, int y, int z) {
		return (x > y) ? (y < z) : (x < z ? (x < y) : x == z);
	}

}
