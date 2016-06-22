package character;

public class Alphabet {

	public static void main(String[] args) {
		char[] arr = new char[26];
		char character = 'A';
		int index = 0;
		while (character <= 'Z') {
			arr[index] = character;
			character++;
			index++;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%s = %-2c", i + 1, arr[i]);
			System.out.println();
		}
	}
}
