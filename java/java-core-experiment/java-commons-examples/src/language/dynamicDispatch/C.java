package language.dynamicDispatch;

public class C implements A {

	@Override
	public void callMe() {
		System.out.println("Inside in callMe method of class C");
	}
}
