package i18n.locales;

import java.util.Locale;

public class AllAvailabeLocales {

	public static void main(String[] args) {
		Locale[] locales = Locale.getAvailableLocales();
		System.out.printf("%1s %1s %1s", "Language", "Country", "LocaleName" + "\n");
		for (int i = 0; i < locales.length; i++) {
			System.out.printf("%6s %6s %9s", locales[i].getLanguage(), locales[i].getCountry(), locales[i].getDisplayName());
			System.out.println();
		}
	}
}
