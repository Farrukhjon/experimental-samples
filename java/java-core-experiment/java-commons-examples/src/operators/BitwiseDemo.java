package operators;

public class BitwiseDemo {

	public static void main(String[] args) {

		System.out.println(Integer.toBinaryString(8));
		System.out.println(Integer.toBinaryString(16));
		System.out.println(Integer.toBinaryString(32));
		System.out.println(Integer.toBinaryString(64));

		final String orBitwiseOper = Integer.toBinaryString(123 | 456);
		final String andBitwiseOper = Integer.toBinaryString(123 & 456);
		final String xorBitwiseOper = Integer.toBinaryString(123 ^ 456);
		final String notBitwiseOper = Integer.toBinaryString(~123);
		Integer ORvalue = Integer.parseInt(orBitwiseOper, 2);
		Integer ANDvalue = Integer.parseInt(andBitwiseOper, 2);
		Integer xorvalue = Integer.parseInt(xorBitwiseOper, 2);
		//Integer notvalue = Integer.parseInt(notBitwiseOper, 2);
		System.out.println(ORvalue);
		System.out.println(ANDvalue);
		System.out.println(xorvalue);
		System.out.println(notBitwiseOper);

	}

}
