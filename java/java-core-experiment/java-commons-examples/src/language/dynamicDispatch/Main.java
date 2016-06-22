package language.dynamicDispatch;

public class Main {

	public static void main(String[] args) {

		B b = new B();
		C c = new C();

		A r;

		r = b;
		r.callMe();

		r = c;
		r.callMe();

	}
}
