package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("ds");
		Matcher matcher = p.matcher("DS");
		matcher.end();
	}
}
