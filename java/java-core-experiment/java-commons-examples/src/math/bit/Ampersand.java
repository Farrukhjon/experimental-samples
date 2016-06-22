package math.bit;

public class Ampersand {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int value = amp(i, 10);
			System.out.println(value);
		}
		int value = amp(62488979, 1024);
		System.out.println(value);
	}

	public static int amp(int a, int b) {
		return a & b-1;
	}

}
