package math;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		Random rand = new Random();
		System.out.println("Random number form 0 or 10 until nextInt !=10:");
		printNextFrom0to10(rand);
		System.out.println("\nRandom number 0 or 1:");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++)
				System.out.printf("%-3s", rand.nextInt(2));
			System.out.println();
		}
	}

	private static void printNextFrom0to10(Random rand) {
		int nextInt = 0;
		while (nextInt != 10) {
			nextInt = rand.nextInt(11);
			System.out.printf("%-3s", nextInt);
		}
	}

}
