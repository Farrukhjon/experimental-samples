package communication.ch3;

import java.util.concurrent.TimeUnit;

public class TaskGetter implements Runnable {

	private Counter	counter;

	public TaskGetter(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		synchronized (counter) {
			while (true) {
				int count = counter.getCount();
				System.out.println("Counter value has been geted: " + count);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}

}
