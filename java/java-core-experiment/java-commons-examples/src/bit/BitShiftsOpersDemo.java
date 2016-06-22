package bit;

public class BitShiftsOpersDemo {

	public static void main(String[] args) {

		int a0 = 0b00000001; // 1
		int a = 0b11111111; // 255
		int b = 0b10000000; // 128

		int c = a << 1; // a*2 = 510 = 111111110
		int d = b >> 1; // b/2 = 64 = 1000000

		assert c == 0b111111110;
		assert d == 0b1000000;

		System.out.println(Integer.toBinaryString(c));
		System.out.println(Integer.toBinaryString(d));

		int x = 192;
		System.out.println(Integer.toBinaryString(x));
		int y = x << 4; //
		System.out.println(Integer.toBinaryString(y));
		System.out.println("--------------------------------------------");
		for (int i = 0; i < 8; i++) {
			int r = a0 << i;
			System.out.printf("%-15s %-3s %1s %n", Integer.toBinaryString(r), r, i);
		}

		System.out.println("--------------------------------------------");
		for (int i = 0; i < 8; i++) {
			int r = a >> i;
			System.out.printf("%-15s %-3s %1s %n", Integer.toBinaryString(r), r, i);
		}

		System.out.println("--------------------------------------------");
		for (int i = 0; i < 10; i++) {
			int r = 1 << i;
			System.out.printf("%-10s %1s %n", i, r);
		}

	}

}
