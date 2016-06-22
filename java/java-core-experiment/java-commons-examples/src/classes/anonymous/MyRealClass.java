package classes.anonymous;

public class MyRealClass {

	public static void main(String[] args) {
		AbstractClass myClass = getRealClass();
		myClass.sayHello();
	}

	private static AbstractClass getRealClass() {
		return new AbstractClass() {
			@Override
			protected void sayHello() {
				System.out.println("Hello");
			}
		};
	}
}
