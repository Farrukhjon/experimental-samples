package org.farrukh.examples.java.io.io.byteIO.objectIO;

import java.awt.Color;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutputStreamDemo {

	public static void main(String[] args) {

		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("resources/app.config"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ConfigurationObj config = new ConfigurationObj();
		try {
			out.writeObject(config);
			System.out.println("The config object of ConfigurationObj class is saved to resources/app.config");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("resources/app.config"));
			ConfigurationObj configIn = (ConfigurationObj) in.readObject();
			System.out.println("The configIn is readed from file stream");
			System.out.println(configIn.toString());
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static class ConfigurationObj implements Serializable {

		private static final long serialVersionUID = 1L;

		private String userHomeDirectory;
		private Color backgroundColor;
		private Color foregroundColor;
		private boolean showTabs;
		private Point paletteWindowPosition;
		private Point toolsWindowPosition;
		private String[] recentFiles;

		public String getUserHomeDirectory() {
			return userHomeDirectory;
		}

		public void setUserHomeDirectory(String userHomeDirectory) {
			this.userHomeDirectory = userHomeDirectory;
		}

		public Color getBackgroundColor() {
			return backgroundColor;
		}

		public void setBackgroundColor(Color backgroundColor) {
			this.backgroundColor = backgroundColor;
		}

		public Color getForegroundColor() {
			return foregroundColor;
		}

		public void setForegroundColor(Color foregroundColor) {
			this.foregroundColor = foregroundColor;
		}

		public boolean isShowTabs() {
			return showTabs;
		}

		public void setShowTabs(boolean showTabs) {
			this.showTabs = showTabs;
		}

		public Point getPaletteWindowPosition() {
			return paletteWindowPosition;
		}

		public void setPaletteWindowPosition(Point paletteWindowPosition) {
			this.paletteWindowPosition = paletteWindowPosition;
		}

		public Point getToolsWindowPosition() {
			return toolsWindowPosition;
		}

		public void setToolsWindowPosition(Point toolsWindowPosition) {
			this.toolsWindowPosition = toolsWindowPosition;
		}

		public String[] getRecentFiles() {
			return recentFiles;
		}

		public void setRecentFiles(String[] recentFiles) {
			this.recentFiles = recentFiles;
		}
	}
}
