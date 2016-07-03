package thread;

public class MultiThreadImprovedDemo {

	public static void main(String[] args) {

		NewThread thread1 = new NewThread("thread1");
		NewThread thread2 = new NewThread("thread2");
		NewThread thread3 = new NewThread("thread3");

		try {
			System.out.println("waiting for end core");
			thread1.getThread().join();
			thread2.getThread().join();
			thread3.getThread().join();
		} catch (InterruptedException e) {
			System.out.println("main thread interruped");
		}
		System.out.println("main thread end");
	}

}
