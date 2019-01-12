package problems.deadlock;

public class Counter implements Runnable {

	@Override
	public void run() {
		incrementBallAfterRun();
		incrementRunAfterBall();
	}

	private void incrementRunAfterBall() {
		synchronized (Balls.class) {
			synchronized (Runs.class) {
				Balls.balls++;
				Runs.runs++;
			}
		}
	}

	private void incrementBallAfterRun() {
		synchronized (Runs.class) {
			synchronized (Balls.class) {
				Runs.runs++;
				Balls.balls++;
			}
		}
	}

}
