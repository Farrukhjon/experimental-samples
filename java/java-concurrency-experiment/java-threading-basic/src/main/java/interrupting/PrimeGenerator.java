package interrupting;

public class PrimeGenerator extends Thread {

	@Override
	public void run() {
		long number = 1L;
		while (true) {
			if (isPrime(number))
				System.out.println("Number " + number + " is prime");
			if (isInterrupted()) {
				System.out.println("The Prime Generator has been interrupted");
				break;
			}
			number++;
		}
	}

	private boolean isPrime(long number) {
		if (number <= 2)
			return true;
		for (long i = 2; i < number; i++)
			if ((number % i) == 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		Thread thread = new PrimeGenerator();
		thread.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}
}
