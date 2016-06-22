package enums;

public class AppleDemo {

	public static void main(String[] args) {
		Apple ap = Apple.App1;
		switch (ap) {
			case App1:
				System.out.println("App1");
				break;
			case App2:
				System.out.println("App2");
				break;
			case App3:
				System.out.println("App3");
				break;
			case App4:
				System.out.println("App4");
				break;
			case App5:
				System.out.println("App5");
				break;
			default:
				System.out.println("Apples");
		}
	}
}
