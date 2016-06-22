package math;

import java.text.DecimalFormat;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class TempRosta {
	public static void main(String[] args) {
		Double[] rCepnie = { 1.0, 0.99, 0.971, 1.028, 1.01, 1.068 };
		System.out.println("Среднегодовой тема роста реализации продукции: " + sredTempRosta(rCepnie) + "%");
		System.out.println("Среднегодовой тема прироста реализации продукции: " + tempPrirosta(rCepnie) + "%");

		Double[] pCepnie = { 1.0, 0.98, 0.955, 1.011, 1.03, 1.06 };
		System.out.println("Среднегодовой тема роста производство продукции: " + sredTempRosta(pCepnie) + "%");
		System.out.println("Среднегодовой тема прироста производство продукции: " + tempPrirosta(pCepnie) + "%");
	}

	private static double sredTempRosta(Double[] tBasis) {
		double result = tBasis[0];
		for (int i = 1; i < 6; i++) {
			result *= tBasis[i];
		}
		result = Math.pow(result, (double) 1 / (double) (tBasis.length - 1));
		return Double.valueOf(new DecimalFormat("#.##").format(result * 100));
	}

	private static double tempPrirosta(Double[] tBasis) {
		return Double.valueOf(new DecimalFormat("#.##").format(sredTempRosta(tBasis) - 100));
	}
}
