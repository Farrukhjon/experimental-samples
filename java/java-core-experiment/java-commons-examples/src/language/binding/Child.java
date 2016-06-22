package language.binding;

public class Child extends Parent {

	private void who() {
		System.out.println("Child#who()");
	}

	public static void whoAmI() {
		System.out.println("Child#whoAmI()");
	}

	@Override
	public void whoAreYou() {
		who();
		System.out.println("Child#whoAreYou()");
	}
}
