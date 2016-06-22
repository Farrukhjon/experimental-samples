package string;

public class TheStringConstantPool {

	public static void main(String[] args) {
		
		String str1 = "Hello"; // storing Hello to string constant pool
		String str2 = "Hello"; // referencing to same address where located Hello
		System.out.println(str1.equals(str2)); // true, means is the same content
		System.out.println(str1 == str2); // true, means is the same object
		
		String str3 = new String("Hello"); // creating new object in the Heap
		System.out.println(str2.equals(str3)); //true
		System.out.println(str2 == str3); //false
	}
	
}
