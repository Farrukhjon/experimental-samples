package org.farrukh.experiments.java.thread;

public class ThreadExtendsExample extends Thread {

	public static void main(String[] args) {
		new ThreadExtendsExample().start();
	}

	@Override
	public void run() {
		System.out.println("Hello from thread");
	}

}
