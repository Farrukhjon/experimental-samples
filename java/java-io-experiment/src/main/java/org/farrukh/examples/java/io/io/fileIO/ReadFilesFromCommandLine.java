package org.farrukh.examples.java.io.io.fileIO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadFilesFromCommandLine {

	public static void main(String[] args) {

		List<File> files = new ArrayList<>();
		if (args.length > 0) {
			for (String name : args) {
				File file = new File(name);
				files.add(file);
			}
		}

		System.out.println(files);

	}

}
