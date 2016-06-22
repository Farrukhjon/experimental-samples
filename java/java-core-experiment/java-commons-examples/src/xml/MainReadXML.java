package xml;

import java.util.List;

public class MainReadXML {

	public static void main(String[] args) {
		StaXParser read = new StaXParser();
		List<Items> readConfig = read.readConfig("config.xml");
		for (Items item : readConfig) {
			System.out.println(item);
		}
	}
}
