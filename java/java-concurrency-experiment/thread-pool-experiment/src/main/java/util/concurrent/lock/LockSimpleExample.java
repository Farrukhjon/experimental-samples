package util.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSimpleExample {

	public static void main(String[] args) {

		final Counter counter = new Counter(new ReentrantLock());
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.printf("Count at thread %s is %d %n", Thread.currentThread().getName(), counter.getCount());
			}
		};
		
		Thread t1 = new Thread(r, "T1");
		Thread t2 = new Thread(r, "T2");
		Thread t3 = new Thread(r, "T3");

		t1.start();
		t2.start();
		t3.start();
	}

	public static class Counter {

        private int count;
        private Lock lock;

        public Counter(Lock lock) {
            this.lock = lock;
        }

        public final int getCount() {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock();
            }
            return count;
        }

    }
}
