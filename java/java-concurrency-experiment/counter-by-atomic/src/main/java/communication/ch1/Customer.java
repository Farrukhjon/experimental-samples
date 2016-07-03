package communication.ch1;

public class Customer implements Runnable {

	private Q	q;

	public Customer(Q q) {
		this.q = q;
		new Thread(this, "customer").start();
	}

	@Override
	public void run() {
		while (true)
			q.getValue();
	}

}
