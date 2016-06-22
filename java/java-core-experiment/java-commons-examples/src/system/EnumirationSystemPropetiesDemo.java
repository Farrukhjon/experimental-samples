package system;

import java.util.Enumeration;
import java.util.Properties;

public class EnumirationSystemPropetiesDemo {

	public static void main(String[] args) {

		Properties properties = System.getProperties();

		Enumeration<Object> enumeration = properties.elements();

		while (enumeration.hasMoreElements())
			System.out.println(enumeration.nextElement());
	}
}
