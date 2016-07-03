package thread;

public class GetCurrentThread {

	public static void main(String[] args) {

		Thread thread = Thread.currentThread();
		System.out.println("Current thread is: " + thread);

		thread.setName("NewNameOfThread");
		System.out.println("Ofter renameing thread: " + thread);

		try {
			for (int i = 10; i > 0; i--) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread closed");
		}
	}
}
