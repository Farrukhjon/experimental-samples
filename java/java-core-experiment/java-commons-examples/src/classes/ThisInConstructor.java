package classes;

public class ThisInConstructor {

	public ThisInConstructor(String str) {
		this.say(str);
	}

	public ThisInConstructor() {
		this("Hello, i'm this - constructor ");
	}

	private void say(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		new ThisInConstructor();
	}
}
