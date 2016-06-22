package org.farrukh.examples.java.io.nio;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathBasicDemo {

	public static void main(String[] args) throws IOException, URISyntaxException {

		final String str = "MyFile.txt";
		File file = new File(str);
		file.createNewFile();

		Path path = Paths.get(str);

		System.out.println(path.getFileName());
		System.out.println(path.getNameCount());
		System.out.println(path.getName(0));
		
	}

}
