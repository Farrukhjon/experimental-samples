package thread;

import java.io.IOException;

public class TryThread extends Thread {

	private String	firstName;
	private String	secondName;
	private long	delay;

	public TryThread(String firstName, String secondName, long delay) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.delay = delay;
		setDaemon(true);
	}

	@Override
	public void run() {
		try {
			while (true) {
				System.out.print(firstName);
				sleep(delay);
				System.out.print(secondName + "\n");
			}
		} catch (InterruptedException e) {
			System.out.println(firstName + secondName + e);
		}
	}

	public static void main(String[] args) {
		Thread first = new TryThread("A ", "a  ", 200L);
		Thread second = new TryThread("B ", "b ", 200L);
		Thread third = new TryThread("C ", "c ", 200L);
		System.out.println("Press Enter when you have had enough...\n");
		first.start();
		second.start();
		third.start();
		try {
			System.in.read();
			System.out.println("Enter pressed...\n");
		} catch (IOException e) {
			System.out.println(e);
		}
		return;
	}
}
