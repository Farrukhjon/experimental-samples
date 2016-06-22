package org.farrukh.examples.patterns.structural.proxy.ch1;

public class Client {

	public static void main(String[] args) {

		Proxy proxy = new Proxy();

		proxy.taskOne();
		proxy.taskTwo();
		proxy.taskThree();

		proxy = new Proxy(new ProxyBaseImpl2());

		proxy.taskOne();
		proxy.taskTwo();
		proxy.taskThree();
	}
}
