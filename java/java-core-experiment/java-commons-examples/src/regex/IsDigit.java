package regex;

public class IsDigit {

	public static void main(String[] args) {
		isDigit("0.0");
		isDigit("a");
		isDigit("1,0");
		isDigit("0x2");
	}

	private static boolean isDigit(String str) {
		if (str.matches("([0-9]+(\\.[0-9]))|([0-9]+(\\,[0-9]))")) {
			System.out.printf("%-3s %1s", str, "is digit\n");
			return true;
		}
		System.out.printf("%-3s %1s", str, "is not digit\n");
		return false;
	}
}
