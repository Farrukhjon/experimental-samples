package org.farrukh.examples.java.collection.general.array;

public class BasicOperationsToArray {

	private int	array[];
	private int	numberOfItem;

	public BasicOperationsToArray(int size) {
		array = new int[size];
		numberOfItem = 0;
	}

	public boolean find(int key) {
		return false;
	}

	public void insert(int value) {
		array[numberOfItem] = value;
		numberOfItem++;
	}

	public void delete(int value) {
		int j;
		for (j = 0; j < numberOfItem; j++)
			if (value == array[j])
				break;
		if (j == numberOfItem)
			return;
		else {
			for (int k = j; k < numberOfItem - 1; k++)
				array[k] = array[k + 1];
			numberOfItem--;
			return;
		}
	}

	public void display() {
		for (int i = 0; i < numberOfItem; i++)
			System.out.println(array[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		BasicOperationsToArray ba = new BasicOperationsToArray(10);

		ba.insert(23);
		ba.insert(13);
		ba.insert(30);
		ba.insert(20);
		ba.insert(12);
		ba.insert(10);
		ba.insert(0);
		ba.insert(1);
		ba.insert(2);
		ba.insert(24);

		ba.display();

		ba.delete(0);
		ba.delete(12);
		ba.delete(30);

		ba.display();

	}

}
