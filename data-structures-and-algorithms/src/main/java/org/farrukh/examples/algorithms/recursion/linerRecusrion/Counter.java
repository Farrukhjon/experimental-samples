package recursion.linerRecusrion;

public class Counter {

	public static void main(String[] args) {
		counter(1024);
	}

	private static void counter(int count) {
		if (count == -1) {
			return;
		} else {
			System.out.println(" [" + count + "]");
			counter(--count);
			return;
		}
	}
}
