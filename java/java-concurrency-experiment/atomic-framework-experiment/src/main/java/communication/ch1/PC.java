package communication.ch1;

public class PC {

	public static void main(String[] args) {
		Q q = new Q();
		new Producer(q);
		new Customer(q);

		System.out.println("For stop press Ctrl+C");
	}

}
