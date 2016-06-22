package regex;

import java.util.regex.Pattern;

public class SimplePatternDemo {

	public static void main(String[] args) {
		
		Pattern pattern = Pattern.compile("%s");
		System.out.println(pattern.pattern());
	}

}
