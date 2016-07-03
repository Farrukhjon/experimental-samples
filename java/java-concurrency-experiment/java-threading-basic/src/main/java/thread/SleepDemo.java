package thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SleepDemo implements Runnable {

	@Override
	public void run() {
		while (true) {
			System.out.printf("%s\n", new Date());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				System.out.printf("The SleepDemo has been interrupted\n");
				return;
			}
		}

	}

	public static void main(String[] args) {
		SleepDemo target = new SleepDemo();
		Thread thread = new Thread(target);
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

}
