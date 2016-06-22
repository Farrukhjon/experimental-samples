package bit;

public class LogicalBitShiftOperDemo {

	public static void main(String[] args) {

		int a = 0b11111111_11111111_11111111_11111111; // a = -1
		int b = a >>> 24; // b = 255; b = 0b00000000_00000000_00000000_11111111

		System.out.printf("%1s %2s %-32s %n", "a = ",  a+";", Integer.toBinaryString(a));
		System.out.printf("%1s %2s %-32s %n", "b = ",  b+";", Integer.toBinaryString(b));
		
	}

}
