package org.farrukh.examples.java.generic.basic;

public class GenObj<T> {

	private T obj;

	public GenObj() {
	}

	public GenObj(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public void printClassName() {
		System.out.println(obj.getClass().getName());
	}

	public static void main(String[] args) {

		GenObj<String> sGenObj = new GenObj<String>("Hello Generic");
		sGenObj.printClassName();

		GenObj<Integer> iGenObj = new GenObj<Integer>(11);
		iGenObj.printClassName();
	}
}
