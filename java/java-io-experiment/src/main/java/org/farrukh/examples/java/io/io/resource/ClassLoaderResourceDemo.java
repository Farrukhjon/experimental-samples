package org.farrukh.examples.java.io.io.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;

public class ClassLoaderResourceDemo {

	private static final String name = "file.txt";

	public static void main(String[] args) throws IOException {
		URL resource = ClassLoaderResourceDemo.class.getResource(name);
		String relevantPath = resource.getPath();
		System.out.println(relevantPath);
		InputStream resourceAsStream = ClassLoaderResourceDemo.class.getResourceAsStream(name);
		OutputStream out = new PrintStream(System.out);
		int v;
		while ((v = resourceAsStream.read()) != -1) {
			out.write(v);
		}
	}

}
