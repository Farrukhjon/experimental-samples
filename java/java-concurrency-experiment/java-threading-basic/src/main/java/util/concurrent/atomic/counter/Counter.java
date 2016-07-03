package util.concurrent.atomic.counter;

public class Counter {

	private int	c	= 0;

	public void increment() {
		c++;
	}

	public void decrement() {
		c--;
	}

	public int value() {
		return c;
	}

}
