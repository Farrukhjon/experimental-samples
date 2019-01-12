package util.concurrent.atomic.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter {

	private AtomicInteger	atomicInt	= new AtomicInteger(0);

	public void increment() {
		atomicInt.incrementAndGet();
	}

	public void decrement() {
		atomicInt.decrementAndGet();
	}

	public int getCount() {
		return atomicInt.get();
	}

}
