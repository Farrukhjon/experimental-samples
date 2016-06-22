package i18n.resourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class DemoResourceBundle {

	public static void main(String[] args) {

		ResourceBundle rb = ResourceBundle.getBundle("i18n.resourceBundle.i18n_ru", Locale.getDefault());
		System.out.println(rb.getString("cancel"));
		
		rb = ResourceBundle.getBundle("i18n.resourceBundle.i18n_en");
		System.out.println(rb.getString("cancel"));
	}
}
