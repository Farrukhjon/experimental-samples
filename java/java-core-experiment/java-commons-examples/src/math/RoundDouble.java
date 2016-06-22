package math;

import java.text.DecimalFormat;
import java.util.Random;

public class RoundDouble {

	public static void main(String[] args) {

		double roundableValue = new Random().nextDouble();

		System.out.println("roundableValue : " + roundableValue);

		// Case 1:
		double rounded = Math.round(roundableValue * 100.0) / 100.0;
		System.out.println("rounded by (Math.round) : " + rounded);

		// Case 2:
		DecimalFormat df = new DecimalFormat("###.##");
		System.out.println("rounded by (DecimalFormat) : " + df.format(roundableValue));
	}

}
