package communication.ch3;

import java.util.concurrent.TimeUnit;

public class TaskSetter implements Runnable {

	private Counter	counter;

	public TaskSetter(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		synchronized (counter) {
			int i = 0;
			while (true) {
				counter.setCount(i);
				System.out.println("Counter value seted to: " + i);
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					return;
				}
				i++;
			}
		}
	}

}
