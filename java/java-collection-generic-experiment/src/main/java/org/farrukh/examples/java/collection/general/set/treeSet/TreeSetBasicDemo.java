package org.farrukh.examples.java.collection.general.set.treeSet;

import java.util.Set;
import java.util.TreeSet;

import org.farrukh.examples.java.collection.pojo.Book;

public class TreeSetBasicDemo {

	public static void main(String[] args) {

		Book book1 = new Book("Java complete reference");
		Book book2 = new Book("MySql Cookbook");
		Book book3 = new Book("HTML reference manual");

		Set<Book> setBook = new TreeSet<>();
		setBook.add(book1);
		setBook.add(book2);
		setBook.add(book3);

		System.out.println(setBook);

		setBook.clear();

		setBook.add(book1);
		setBook.add(book2);
		setBook.add(book3);

		System.out.println(setBook);

	}

}
