package math;

public class OddEven {

	public static void main(String[] args) {

		int index = 0;
		while (true) {
			int idx = index;
			if (idx % 2 == 1)
				System.out.println(idx % 2 + " = even");
			else
				System.out.println(idx % 2 + " = odd");
			index++;
			if (index == 10)
				break;
		}
	}

}
