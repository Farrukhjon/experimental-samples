package org.farrukh.examples.java.collection.concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockingQueueDemo {

	public static void main(String[] args) throws InterruptedException {

		final String[] strs = { "A", "B", "C", "D", "E" };

		final BlockingQueue<String> bq = new ArrayBlockingQueue<>(1024);

		Thread t1 = new Thread() {

			@Override
			public void run() {
				try {
					for (int i = 0; i < strs.length; i++) {
						final String e = strs[i];
						bq.put(e);
						System.out.println("put to blocking queue: " + e);
						Thread.sleep(3000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < strs.length; i++) {
						final String value = bq.take();
						System.out.println("taked value: " + value);
						Thread.sleep(3000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		t1.start();
		t2.start();

		Thread.sleep(5000);
	}

}
