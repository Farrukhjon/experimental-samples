package formating;

import java.text.DecimalFormat;
import java.util.Formatter;

public class DecimalFormatBy4Way {

	public static void main(String[] args) {
		DecimalFormat formatter1 = new DecimalFormat("###,###.###");
		DecimalFormat formatter2 = new DecimalFormat("###.###");
		DecimalFormat formatter3 = new DecimalFormat("000000.000");
		DecimalFormat formatter4 = new DecimalFormat("$###,###.###");

		String pi = formatter1.format(Math.PI);
		System.out.println("Formating Math.PI by using DecimalFormat format() method with pattern ###,###.###: " + pi);

		pi = formatter2.format(Math.PI);
		System.out.println("Formating Math.PI by using DecimalFormat format() method with pattern ###.###: " + pi);

		pi = formatter3.format(Math.PI);
		System.out.println("Formating Math.PI by using DecimalFormat format() method with pattern 000000.000: " + pi);

		pi = formatter4.format(Math.PI);
		System.out.println("Formating Math.PI by using DecimalFormat format() method with pattern $###,###.###: " + pi);

		pi = String.format("%.3f", Math.PI);
		System.out.println("Formating Math.PI by using String.format() method: " + pi);

		System.out.printf("Formating Math.PI by using System.out.printf() method : %.05f %n", Math.PI);

		Formatter formatter = new Formatter();
		String result = formatter.format("%.4f", Math.PI).toString();
		formatter.close();
		System.out.println("Formating Math.PI by using java.util.Formatter.format() method: " + result);

	}

}
