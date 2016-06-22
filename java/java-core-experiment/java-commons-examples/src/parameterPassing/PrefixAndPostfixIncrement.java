package parameterPassing;

public class PrefixAndPostfixIncrement {

	public static void main(String[] args) {
		int i = 0;
		System.out.println("i = " + i);
		int result = ++i; // prefix incrmenting retrun NEW value. This is equal to: i = i + 1; result = i; return result;
		System.out.println("result of ++i: " + result);

		result = i++; // postfix incrmenting retrun OLD value. This is equal to: result = i; i = i + 1; return result; 
		System.out.println("result of i++: " + result);
		System.out.println("i = " + i);
	}

}
