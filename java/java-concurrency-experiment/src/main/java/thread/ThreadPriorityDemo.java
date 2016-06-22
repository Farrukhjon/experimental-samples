package thread;

public class ThreadPriorityDemo {

	public static void main(String[] args) {
		
		Thread thread0 = new Thread("thread0");
		Thread thread1 = new Thread("thread1");
		Thread thread2 = new Thread("thread2");

		thread0.setPriority(Thread.MIN_PRIORITY);
		thread1.setPriority(Thread.NORM_PRIORITY);
		thread2.setPriority(Thread.MAX_PRIORITY);

		print(thread0);
		print(thread1);
		print(thread2);

	}

	private static void print(Thread t) {
		System.out.println(t);
	}

}
