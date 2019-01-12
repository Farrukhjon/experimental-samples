package org.farrukh.examples.exceptions.exceptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TryWithResourcesDemo {

	private static final String	fileName	= "src/exceptions/exceptions/file.txt";

	public static void main(String[] args) {

		List<String> strs = new ArrayList<>();
		// The resources must be AutoCloseable
		final File file = new File(fileName);
		try (Scanner scanner = new Scanner(System.in); FileOutputStream f = new FileOutputStream(file)) {
			while (scanner.hasNext()) {
				String next = scanner.next();
				strs.add(next);
				f.write(next.getBytes());
				f.write("\n".getBytes());
			}
			f.flush();
			System.out.println(strs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
