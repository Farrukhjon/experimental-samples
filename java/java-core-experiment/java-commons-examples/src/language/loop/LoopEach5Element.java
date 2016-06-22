package language.loop;

public class LoopEach5Element {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		int j = 0;
		int base = 0;
		while (j < 3) {
			for (int i = 0; i < 6; i++) {
				System.out.println(a[base + i]);
			}
			base += 7;
			j++;
		}
	}
}
