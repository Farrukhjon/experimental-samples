package org.farrukh.experiments.dp.structural.proxy.ch2;

public class RealImage implements IImage {
	
	private String fileName = null;
	
	public RealImage(String fileName) {
		this.fileName = fileName;
	}
	
	public void drawImage() {
		System.out.println("Displaying " + fileName);
	}

}
