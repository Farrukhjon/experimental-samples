package communication.ch4;

public class CoffeeMachine extends Thread {

	static String	coffeeMade		= null;
	static int		coffeeNumber	= 1;
	static Object	lock			= new Object();

	public void makeCoffee() {
		synchronized (lock) {
			if (coffeeMade != null)
				try {
					System.out.println("Coffee machine: Waiting for waiter notification to deliver the coffee");
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			coffeeMade = "Coffee No. " + coffeeNumber++;
			System.out.println("Coffee machine says: Made " + coffeeMade);
			// once coffee is ready, notify the waiter to pick it up
			lock.notifyAll();
			System.out.println("Coffee machine: Notifying waiter to pick the coffee ");
		}
	}

	@Override
	public void run() {
		while (true) {
			makeCoffee();
			try {
				System.out.println("Coffee machine: Making another coffee now");
				// simulate the time taken to make a coffee by calling sleep method
				Thread.sleep(10000);
			} catch (InterruptedException ie) {
				// its okay to ignore this exception since we're not using thread interrupt mechanism
				ie.printStackTrace();
			}
		}
	}
}
