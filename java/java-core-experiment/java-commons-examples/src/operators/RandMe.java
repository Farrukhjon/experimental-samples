package operators;

import java.util.Random;

public class RandMe {

	public static void main(String[] args) {
		Random rand = new Random(5);
		for (int i = 0; i < 24; i++) {
			int x = rand.nextInt() / 99999;
			if (x > 0) {
				System.out.println(x);
			}
		}
	}
}
