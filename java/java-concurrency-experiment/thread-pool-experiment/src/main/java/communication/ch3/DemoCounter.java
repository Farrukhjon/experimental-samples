package communication.ch3;

import java.util.concurrent.TimeUnit;

public class DemoCounter {

	public static void main(String[] args) {
		
		Counter counter = new Counter();
		
		Thread t1 = new Thread(new TaskSetter(counter));
		Thread t2 = new Thread(new TaskGetter(counter));

		t1.start();
		t2.start();

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		t1.interrupt();
		t2.interrupt();

	}
}
