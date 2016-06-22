package org.farrukh.examples.java.collection.pojo;

public class Book implements Comparable<Book> {

	private String	name;

	public Book(String name) {
		super();
		this.name = name;
	}

	@Override
	public int compareTo(Book o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return "Book [name=" + name + "]";
	}

}
