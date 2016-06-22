package bit;

public class BitShiftsOpersBasicDemo {

	public static void main(String[] args) {
		
		int a = 0b00000000_00000001; // 1
		
		System.out.println(a);
		
		int notA = ~a;
		
		int b = 0xff; //0
		int notB = ~b;
		System.out.printf("%-4s %s %n", notA, Integer.toBinaryString(notA));
		System.out.printf("%-4s %s", notB, Integer.toBinaryString(notB));
	}

}
