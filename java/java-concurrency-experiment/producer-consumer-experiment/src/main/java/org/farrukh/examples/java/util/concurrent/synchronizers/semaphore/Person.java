package util.concurrent.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

public class Person extends Thread {

	private Semaphore	machines;

	public Person(Semaphore machines, String name) {
		this.machines = machines;
		this.setName(name);
	}

	@Override
	public void run() {
		try {
			System.out.println(getName() + " waiting to access an ATM machine");
			machines.acquire();
			System.out.println(getName() + " is accessing an ATM machine");
			Thread.sleep(1000); // simulate the time required for withdrawing amount
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(getName() + " is done using the ATM machine");
			machines.release();
		}
	}

}
