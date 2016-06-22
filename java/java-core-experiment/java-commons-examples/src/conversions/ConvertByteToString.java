package conversions;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class ConvertByteToString {

	public static void main(String[] args) throws UnsupportedEncodingException {

		byte[] bytes = "ABSCDFFDCSBA".getBytes();
		System.out.println(Arrays.toString(bytes));

		String str1 = new String(bytes);
		System.out.println(str1);

		String str2 = new String(bytes, "UTF-8");
		System.out.println(str2);
	}

}
