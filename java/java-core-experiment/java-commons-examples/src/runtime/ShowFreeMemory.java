package runtime;

public class ShowFreeMemory {

	public static void main(String[] args) {
		final long freeMemory = Runtime.getRuntime().freeMemory();
		System.out.println(freeMemory / 2048);
	}

}
