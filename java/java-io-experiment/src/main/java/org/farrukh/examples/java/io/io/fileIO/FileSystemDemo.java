package org.farrukh.examples.java.io.io.fileIO;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

public class FileSystemDemo {

	public static void main(String[] args) {
		FileSystemView fsys = FileSystemView.getFileSystemView();
		String desktop = fsys.getHomeDirectory().getName();
		System.out.println(desktop);
		File[] files = fsys.getRoots();
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i].getName());
		}
		String userHome = System.getProperty("user.home") + "\\" + desktop;
		System.out.println(userHome);
		System.out.println(getDesktopPath());
	}
	
	private static String getDesktopPath(){
		String desktopName = FileSystemView.getFileSystemView().getHomeDirectory().getName();
		String desktopPath = System.getProperty("user.home") + "\\" + desktopName;
		return desktopPath;
	}
}
