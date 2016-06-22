package enums;

public class AppleDemo2 {

	public static void main(String[] args) {
		Apple[] apples = Apple.values();

		for (Apple a : apples) {
			System.out.print(a);
			System.out.println(" " + a.ordinal());
		}

		Apple ap = Apple.valueOf("App1");
		System.out.println("------");
		System.out.print(ap);
		System.out.println(" " + ap.ordinal());
	}
}
