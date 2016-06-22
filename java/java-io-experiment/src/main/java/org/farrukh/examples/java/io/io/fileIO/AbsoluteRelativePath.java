package org.farrukh.examples.java.io.io.fileIO;

import java.io.File;

public class AbsoluteRelativePath {

	public static void main(String[] args) {

		File absolute = new File("/public/html/javafaq/index.html");
		File relative = new File("html/javafaq/index.html");
		System.out.println("absolute: ");
		System.out.println(absolute.getName());
		System.out.println(absolute.getPath());
		System.out.println("relative: ");
		System.out.println(relative.getName());
		System.out.println(relative.getPath());
	}
}
