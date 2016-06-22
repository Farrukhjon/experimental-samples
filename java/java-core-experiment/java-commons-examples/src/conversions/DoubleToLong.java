package conversions;

public class DoubleToLong {

	public static void main(String[] args) {

		double dValue = 128.999;
		// using Double.longValue();
		long lValue = (new Double(dValue)).longValue();
		System.out.println(lValue);

		// using just casting approach
		long elValue = (long) dValue;
		System.out.println(elValue);

		// using Math.round method
		long llValue = Math.round(dValue);
		System.out.println(llValue);
	}
}
