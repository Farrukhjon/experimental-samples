package org.farrukh.examples.java.generic.hierarchy;

public class Gen<T> {

	private T obj;

	public Gen(T obj) {
		this.setObj(obj);
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
}
