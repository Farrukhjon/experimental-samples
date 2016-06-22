package conversions;

public class WideningPrimitiveConvertion {

	public static void main(String[] args) {

		int big = 1234567890;
		float approx = big; //lost information from big
		System.out.println(big - (int) approx);
		
		double d = big; // Does'n lose information from big
		System.out.println(big - (int) d);

	}

}
