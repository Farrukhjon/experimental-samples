package org.farrukh.examples.java.io.io.byteIO;

public class ReadArgumentFromConsole {

	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		int[][] array = new int[n][m];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j] = (int) Math.pow(i, 2);
				System.out.print("[" + array[i][j] + "]");
			}
			System.out.println();
		}
	}

}
