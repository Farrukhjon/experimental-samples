package search;

public class LinerSearch {

	public static void main(String[] args) {
		int[] data = { 12, 45, 545, 78, 0, -53, 58, -895, 1 };
		System.out.println(find(data, -53));
	}

	public static int find(int[] data, int key) {
		for (int i = 0; i < data.length; i++) {
			int element = data[i];
			if (element == key)
				return key;
		}
		return -1;
	}
}
