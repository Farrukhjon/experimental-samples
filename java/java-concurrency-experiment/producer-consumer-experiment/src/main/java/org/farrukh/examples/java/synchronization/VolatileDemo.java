package synchronization;

public class VolatileDemo {

	private volatile int	count	= 0;

	public void inc() {
		count++;
	}

	public int getCount() {
		return count;
	}

	public static void main(String[] args) {

		final VolatileDemo volatileDemo = new VolatileDemo();

		System.out.println(volatileDemo.getCount());

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				volatileDemo.inc();
				System.out.println(Thread.currentThread().getName());
			}
		}, "t1");
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				volatileDemo.inc();
				System.out.println(Thread.currentThread().getName());
			}
		}, "t2");
		t2.start();

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				final int result = volatileDemo.getCount();
				System.out.println(result);
			}
		}, "t3");
		t3.start();
	}

}
