package org.farrukh.examples.java.collection.general.Iterator;

import java.util.Iterator;
/**
 * 
 * @author Farrukh SATTOROV
 *
 */
public class Counter implements Iterable<Integer> {

	private int[]	count;
	private int		n	= -1;

	public Counter(int size) {
		this.count = new int[size];
	}

	public void add(int item) {
		n++;
		count[n] = item;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			private int	cursor	= 0;

			@Override
			public boolean hasNext() {
				return cursor != count.length;
			}

			@Override
			public Integer next() {
				int value = count[cursor];
				cursor++;
				return value;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

		};
	}

	public static void main(String[] args) {
		Counter counter = new Counter(10);
		counter.add(0);
		counter.add(1);
		counter.add(2);
		counter.add(3);
		counter.add(4);
		counter.add(5);
		counter.add(6);
		counter.add(77);
		counter.add(88);
		counter.add(99);

		for (int value : counter) {
			System.out.print(value + " ");
		}
	}
}
