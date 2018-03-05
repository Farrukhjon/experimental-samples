package org.farrukh.examples.java.collection.concurrent.list;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class CopyOnWriteArrayListDemo {

	private volatile static int	count	= 0;

	public static void main(String[] args) {

		final CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						cowList.add(count);
						System.out.println(count + " added to cowList by t1");
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						System.out.println("out from t1");
						return;
					}
					count++;
				}
			};
		});
		t1.setPriority(Thread.MAX_PRIORITY);

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						cowList.add(count);
						System.out.println(count + " added to cowList by t2");
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						System.out.println("out from t1");
						return;
					}
					count++;
				}
			}
		});
		t2.setPriority(Thread.MIN_PRIORITY);

		t1.start();
		t2.start();

		try {
			TimeUnit.SECONDS.sleep(5);
			t1.interrupt();
			t2.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(cowList);

	}
}
