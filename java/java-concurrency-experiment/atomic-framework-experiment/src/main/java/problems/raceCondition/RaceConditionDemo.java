package problems.raceCondition;

public class RaceConditionDemo {

	public static void main(String[] args) {

		RunnableCounter r = new RunnableCounter();

		Thread t1 = new Thread(r, "T1");
		Thread t2 = new Thread(r, "T2");
		Thread t3 = new Thread(r, "T3");

		t1.start();
		t2.start();
		t3.start();
	}

}
