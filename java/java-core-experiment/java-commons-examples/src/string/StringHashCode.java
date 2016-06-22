package string;

public class StringHashCode {

	public static void main(String[] args) {

		String str0 = "str0";
		int hash0 = str0.hashCode();
		System.out.println(hash0);

		String str1 = "1rts";
		int hash1 = str1.hashCode();
		System.out.println(hash1);

		String str2 = new String(hash0 + "++");
		System.out.println(str2);
	}

}
