package runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderDemo {

	public static void main(String[] args) throws IOException {
		String[] command = { "mysql", "--version" };
		ProcessBuilder processBuilder = new ProcessBuilder(command);
		processBuilder.redirectErrorStream(true);
		Process process = processBuilder.start();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
	}
}
