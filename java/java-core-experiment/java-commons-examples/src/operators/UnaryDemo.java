package operators;

public class UnaryDemo {

	public static void main(String[] args) {

		int count = 10;
		while (count >= 0) {
			System.out.print(" count " + count);
			count--;
		}
		System.out.println();
		while (count <= 10) {
			System.out.print(" count " + count);
			count++;
		}
	}

}
