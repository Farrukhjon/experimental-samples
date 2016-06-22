package language.binding;

public class Parent {

	private void who() {
		System.out.println("Inside private method Parent#who()");
	}

	public static void whoAmI() {
		System.out.println("Inside static method, Parent#whoAmI()");
	}

	public void whoAreYou() {
		who();
		System.out.println("Inside virtual method, Parent#whoAreYou()");
	}
}
