package org.farrukh.experiments.java.thread;

public class MainAndTwoThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new Run1(), "run1");
		Thread thread2 = new Thread(new Run2(), "run2");
		thread1.start();
		thread2.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName());
			Thread.sleep(1000);
		}
	}

	private static class Run1 implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++)
				try {
					System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}

	private static class Run2 implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++)
				try {
					System.out.println(Thread.currentThread().getId() + " " + Thread.currentThread().getName());
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
}
