package language;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VoidReturnDemo {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while (!(str = br.readLine()).equals("end")) {
			showStr(str);
		}
	}

	private static void showStr(String str) {
		if (str.equals("begin"))
			return;
		System.out.println(str);
	}
}
