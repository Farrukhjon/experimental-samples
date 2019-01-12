package communication.ch1;

import java.util.concurrent.TimeUnit;

public class Q {

	private int		n;
	private boolean	isValueSeted	= false;

	public synchronized int getValue() {
		if (!isValueSeted)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("value taked: " + n);
		isValueSeted = false;
		notify();
		return n;
	}

	public synchronized void putValue(int n) {
		if (isValueSeted)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.n = n;
		isValueSeted = true;
		System.out.println("value seted: " + n);
		notify();
	}

}
