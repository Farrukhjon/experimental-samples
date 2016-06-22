package classes;

public class TestGetClassMethod {

	private static String	foo;
	private static Object	obj;

	public static void main(String[] args) {
		foo = "this this a string";
		obj = foo;
		System.out.println(foo.getClass().getName());
		System.out.println(obj.toString());
	}
}
