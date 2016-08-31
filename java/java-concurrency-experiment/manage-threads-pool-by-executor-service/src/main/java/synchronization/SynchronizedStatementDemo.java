package synchronization;

public class SynchronizedStatementDemo {

	public static void main(String[] args) {

		TargetClass target = new TargetClass();

		MyThread thread1 = new MyThread(1, target);
		MyThread thread2 = new MyThread(2, target);
		MyThread thread3 = new MyThread(3, target);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}
