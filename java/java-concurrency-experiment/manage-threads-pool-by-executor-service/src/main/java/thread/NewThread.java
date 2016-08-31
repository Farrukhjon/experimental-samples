package thread;

public class NewThread implements Runnable {

	private Thread	thread;
	private String	name;

	public NewThread(String name) {
		this.name = name;
		thread = new Thread(this, name);
		System.out.println("new thread " + name);
		thread.start();
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(name + ": " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException exception) {
			System.out.println(name + " " + "interrupted");
		}
	}

	public Thread getThread() {
		return thread;
	}
}
