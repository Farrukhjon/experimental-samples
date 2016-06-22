package bit;

public class AndBitwiseOper {

	public static void main(String[] args) {

		for (int i = 1; i <= 255; i++) {
			System.out.printf("%-10s %-10s %1s %n", Integer.toBinaryString(i & 0xff), Integer.toBinaryString(i & 0xff), i);
		}
	}

}
