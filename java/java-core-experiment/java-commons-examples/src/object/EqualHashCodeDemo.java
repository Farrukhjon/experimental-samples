package object;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EqualHashCodeDemo {

	public static void main(String[] args) {

		Country tajikistan1 = new Country();
		tajikistan1.setName("Tajikistan");
		Country tajikistan2 = new Country();
		tajikistan2.setName("Tajikistan");

		System.out.println("is tajikistan1 equal to tajikistan2: " + tajikistan1.equals(tajikistan2));

		Map<Country, String> countryCapitalMap = new HashMap<Country, String>();
		countryCapitalMap.put(tajikistan1, "Dushanbe");
		countryCapitalMap.put(tajikistan2, "Dushanbe");

		Iterator<Country> iterator = countryCapitalMap.keySet().iterator();
		while (iterator.hasNext()) {
			Country country = iterator.next();
			String capital = countryCapitalMap.get(country);
			System.out.println("Capital of " + country.getName() + " is " + capital);
		}
	}

}
