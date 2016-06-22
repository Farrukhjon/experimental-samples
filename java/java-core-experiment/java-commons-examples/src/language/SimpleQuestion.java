package language;

public class SimpleQuestion {

	static boolean yesOrNo(String s) {
		s = s.toLowerCase();
		if (s.equals("yes") || s.equals("y") || s.equals("t"))
			s = "true";
		return Boolean.getBoolean(s);
	}

	public static void main(String[] args) {

		System.out.println(yesOrNo("true") + "" + yesOrNo("Yes"));
	}
}
