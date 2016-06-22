package language;

public class PassParamByValue {

	private int	b	= 1;

	public static void main(String[] args) {
		int a = 1;
		PassParamByValue paramByValue = new PassParamByValue();
		System.out.println("Before modify:" + a);
		paramByValue.modify(a);
		System.out.println("After modify:" + a);
		System.out.println(paramByValue.b);
		paramByValue.modify(paramByValue);
		System.out.println(paramByValue.b);
	}

	public void modify(int a) {
		a = a + 1;
		System.out.println("Copy of a = " + a);
	}

	public void modify(PassParamByValue a) {
		a.b = a.b + 1;
		System.out.println("Copy of a = " + a.b);
	}

}
