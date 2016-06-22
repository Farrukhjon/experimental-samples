package org.farrukh.examples.java.io.nio.metadata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileAttributesDemo {

	public static void main(String[] args) {
		try {
			Path file = Paths.get("MyFile.txt");
			BasicFileAttributes attributes = Files.readAttributes(file, BasicFileAttributes.class);
			System.out.println("creationTime: " + attributes.creationTime());
			System.out.println("lastAccessTime: " + attributes.lastAccessTime());
			System.out.println("lastModifiedTime: " + attributes.lastModifiedTime());

			System.out.println("isDirectory: " + attributes.isDirectory());
			System.out.println("isOther: " + attributes.isOther());
			System.out.println("isRegularFile: " + attributes.isRegularFile());
			System.out.println("isSymbolicLink: " + attributes.isSymbolicLink());
			System.out.println("size: " + attributes.size());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
