package org.farrukh.experiments.java.thread;

public class JoinMethodDemo extends Thread {

	private static String[]	time	= { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	@Override
	public void run() {
		for (int i = 9; i >= 0; i--)
			try {
				System.out.println(time[i]);
				Thread.sleep(1000); // Reference to current thread and call sleep to one second
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread countdown = new JoinMethodDemo();
		System.out.println("Starting 10 second countdown... ");
		countdown.start();
		System.out.println("Waits until countdown die");
		countdown.join(); // Waits until countdown die
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = time.length - 1; i >= 0; i--) {
					try {
						System.out.println("Boom!!! " + time[i] );
						Thread.sleep(1000); // Reference to current thread and call sleep to one seconds
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();

		System.out.println("Waits until thread1 (reverse countdown) die");
		thread1.join(); // Waits until thread1 die

		System.out.println("Bakh Babakh!!!, end of all threads");
	}
}
