package problems.raceCondition;

public class AvoidingRaceConditionBySynchronizedBlock {

	public static void main(String[] args) {

		RunnableCounter counter = new RunnableCounter() {
			@Override
			public void run() {
				synchronized (this) {
					inc();
					inc();
					inc();
				}
			}
		};

		Thread t1 = new Thread(counter);
		Thread t2 = new Thread(counter);
		Thread t3 = new Thread(counter);

		t1.start();
		t2.start();
		t3.start();
	}

}
