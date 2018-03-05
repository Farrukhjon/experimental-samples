package org.farrukh.examples.java.collection.general.list.linkedList;

import java.util.AbstractCollection;
import java.util.Iterator;

public class SingleLinkedList<E> extends AbstractCollection<E> {

	protected Entry<E>	head;

	public SingleLinkedList() {
		head = null;
	}

	protected class Entry<E> {
		protected E			element;
		protected Entry<E>	next;
	}

	private final class LinkedListIterator implements Iterator<E> {

		Entry<E>	next	= head;

		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public E next() {
			final E element = next.element;
			next = next.next;
			return element;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public void addToFront(E element) {
		Entry<E> newEntry = new Entry<E>();
		newEntry.element = element;
		newEntry.next = head;
		head = newEntry;
	}

	@Override
	public boolean contains(Object obj) {
		if (obj == null) {
			for (Entry<E> current = head; current != null; current = current.next)
				if (obj == current.element)
					return true;
		} else
			for (Entry<E> current = head; current != null; current = current.next)
				if (obj.equals(current.element))
					return true;
		return false;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}

	@Override
	public int size() {
		int count = 0;
		for (Entry<E> current = head; current != null; current = current.next)
			count++;
		return count;
	}

	public static void main(String[] args) {

		SingleLinkedList<String> sll = new SingleLinkedList<>();
		sll.addToFront("Ali");
		sll.addToFront("Vali");
		sll.addToFront("Surayo");
		sll.addToFront("Muhayo");

		final Iterator<String> iterator = sll.iterator();
		while (iterator.hasNext()) {
			System.out.print(" " + iterator.next());
		}
		System.out.println();
		for (String str : sll) {
			System.out.print(" " + str);
		}
	}
}
