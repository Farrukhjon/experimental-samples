package org.farrukh.experiments.dp.structural.proxy.ch2;

public class Client {

	public static void main(String[] args) {
		IImage image1 = new ProxyImage("myImage");
		IImage image2 = new ProxyImage("yourImage");
		image1.drawImage();
		image2.drawImage();
	}
}
