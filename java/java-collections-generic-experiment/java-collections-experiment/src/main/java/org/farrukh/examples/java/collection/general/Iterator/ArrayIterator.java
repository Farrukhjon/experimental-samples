package org.farrukh.examples.java.collection.general.Iterator;

import java.util.Iterator;

public class ArrayIterator {
	private ArrayIterator() {
		super();
	}

	public static Iterator<?> iterator(Object[] array, int offset, int length) {
		return new ArrayUtilIterator(array, offset, length);
	}

	private static class ArrayUtilIterator implements Iterator<Object> {
		private final Object[]	array;
		private final int		top;
		private int				offset;

		ArrayUtilIterator(Object[] array, int offset, int length) {
			this.array = array;
			this.offset = offset;
			this.top = offset + length;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			return this.offset < this.top;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#next()
		 */
		public Object next() {
			return this.array[this.offset++];
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#remove()
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
