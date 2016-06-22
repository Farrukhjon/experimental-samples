package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResistByOm {

	public static void main(String[] args) {
		System.out.println("Введите исходные данные:");

		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(input);
		try {
			System.out.println("Величина первого сопротивления:");
			Double r1 = Double.parseDouble(br.readLine());

			System.out.println("Величина второго сопротивления:");
			Double r2 = Double.parseDouble(br.readLine());

			System.out.println("Тип соединение:");
			Integer t = Integer.parseInt(br.readLine());

			if (t == 1) {
				System.out.println(r1 + r2);

			} else if (t == 2) {
				System.out.println((r1 * r2) / (r1 + r2));
			}
			System.out.println("Тип не определен");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
