package i18n.locales;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class AvailableLocales {

	public static void main(String[] args) {
		List<Locale> locales = Arrays.asList(Locale.getAvailableLocales());
		for (Locale l : locales) {
			System.out.printf("%-10s %1s", l, l.getDisplayName());
			System.out.println();
		}
	}
}
