package org.farrukh.experiments.java.thread;

public class MultiThreadDemo1 {

	class FirstTargetByRun implements Runnable {

		@Override
		public void run() {
			while (true) {
				System.out.println("firstTarget");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class FirstTargetByTread extends Thread {
		
		@Override
		public void run() {
			while (true) {
				System.out.println("firstTarget");
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	class SecondTargetByRun implements Runnable {
		
		@Override
		public void run() {
			while (true) {
				System.out.println("secondTarget");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new MultiThreadDemo1().new FirstTargetByTread());
		Thread t2 = new Thread(new MultiThreadDemo1().new SecondTargetByRun());
		t1.start();
		t2.start();
	}

}
