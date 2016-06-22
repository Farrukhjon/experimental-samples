package language.dynamicDispatch;

public class B implements A {

	@Override
	public void callMe() {
		System.out.println("Inside in callMe method of class B");
	}
}
