package util.concurrent.synchronizers.semaphore;

import java.util.concurrent.Semaphore;

public class ATMRoom {

	public static void main(String[] args) {
		// assume that only two ATM machines are available in the ATM room
		int countOfATM = 2;
		Semaphore machines = new Semaphore(countOfATM);

		// list of people waiting to access the machine
		Person mickey = new Person(machines, "Mickey");
		mickey.start();

		Person donald = new Person(machines, "Donald");
		donald.start();

		Person tom = new Person(machines, "Tom");
		tom.start();

		Person jerry = new Person(machines, "Jerry");
		jerry.start();


		Person casper = new Person(machines, "Casper");
		casper.start();
	}

}
