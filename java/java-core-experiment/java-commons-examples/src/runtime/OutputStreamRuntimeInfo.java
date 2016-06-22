package runtime;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamRuntimeInfo {

	public static void main(String[] args) throws IOException {

		Process process = Runtime.getRuntime().exec("mysql --help");
		Process process2 = Runtime.getRuntime().exec("mysqldump --help");
		OutputStream out = System.out;
		while (true) {
			int c = process.getInputStream().read();
			if (c == -1)
				break;
			out.write((char) c);
		}
		while (true) {
			int c = process2.getInputStream().read();
			if (c == -1)
				break;
			out.write((char) c);
		}
	}
}
