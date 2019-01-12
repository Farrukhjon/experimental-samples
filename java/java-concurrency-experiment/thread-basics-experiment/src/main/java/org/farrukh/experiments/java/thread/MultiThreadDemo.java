package org.farrukh.experiments.java.thread;

public class MultiThreadDemo {

	public static void main(String[] args) {

		final NewThread thread0 = new NewThread("thread0");
		final NewThread thread1 = new NewThread("thread1");
		final NewThread thread2 = new NewThread("thread2");
		
		try {
			thread0.getThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			thread1.getThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			thread2.getThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
