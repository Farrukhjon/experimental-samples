package language.loop;

public class IfInLoop {

	public static void main(String[] args) {
		isTrue('A');
	}

	private static boolean isTrue(char ch) {
		for (int i = 0; i < 10; i++)
			if (ch == 'A')
				return true;
		return false;
	}

}
