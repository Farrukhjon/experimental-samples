package synchronization;

public class SynchronizedMathodDemo {

	public static void main(String[] args) {
		
		final SynchronizedMathodDemo target = new SynchronizedMathodDemo();
		
		Thread t1 = new Thread("t1") {
			@Override
			public void run() {
				System.out.println(target.synchSqr(2));
				synchronized (target) {
					System.out.println(target.sqr(2));
				}
			}
		};
		Thread t2 = new Thread("t2") {
			@Override
			public void run() {
				System.out.println(target.synchSqr(3));
				synchronized (target) {
					System.out.println(target.sqr(3));
				}
			}
		};
		Thread t3 = new Thread("t3") {
			@Override
			public void run() {
				System.out.println(target.synchSqr(4));
				synchronized (target) {
					System.out.println(target.sqr(4));
				}
			}
		};

		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);

		t1.start();
		t2.start();
		t3.start();
	}

	private synchronized double synchSqr(double a) {
		return Math.pow(a, 2);
	}

	private double sqr(double a) {
		return Math.pow(a, 2);
	}

}
