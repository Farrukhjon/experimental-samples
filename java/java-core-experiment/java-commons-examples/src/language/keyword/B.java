package language.keyword;

public class B extends A {

	@Override
	public void doLogic() {
		System.out.println("Logic from class B");
	}

	public void doDifferentLogic() {
		System.out.println("Different logic from B");
		super.doLogic();
	}
}
