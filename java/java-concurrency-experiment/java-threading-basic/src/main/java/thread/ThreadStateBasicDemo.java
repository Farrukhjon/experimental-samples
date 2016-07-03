package thread;

public class ThreadStateBasicDemo implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new ThreadStateBasicDemo());
		System.out.println("Thread state after constructing is: " + thread.getState());
		thread.start();
		System.out.println("Thread state after calling start() is: " + thread.getState());
		thread.join();
		System.out.println("Thread state after calling join() is:" + thread.getState());
	}

	@Override
	public void run() {

	}

}
