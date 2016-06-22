package formating;

import java.text.DecimalFormat;

public class RoundTwoDecimals {

	public static void main(String[] args) {
		System.out.println(roundTwoDecimals(4444.3344445));

	}

	private static double roundTwoDecimals(double d) {
		return Double.valueOf(new DecimalFormat("#.##").format(d));
	}
}
