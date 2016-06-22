package runtime;

public class MaxMemory {

	public static void main(String[] args) {
		final long maxMemory = Runtime.getRuntime().maxMemory(); // in byte
		System.out.println("maxMemory: " + maxMemory / 2048 + " mb");
	}

}
