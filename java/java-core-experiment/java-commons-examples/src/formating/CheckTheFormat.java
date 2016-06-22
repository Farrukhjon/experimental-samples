package formating;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CheckTheFormat {
	public static void main(String args[]) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		while (true) {
			System.out.print("Radius? ");
			String str = br.readLine();
			double radius;
			try {
				radius = Double.valueOf(str).doubleValue();
			} catch (NumberFormatException nfe) {
				System.out.println("Incorrect formating!");
				continue;
			}
			if (radius <= 0) {
				System.out.println("Radius must be positive!");
				continue;
			}
			System.out.println("radius " + radius);
			return;
		}
	}
}
