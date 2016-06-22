package org.farrukh.examples.java.generic.hierarchy;

public class SubGen<T, V> extends Gen<T> {

	private T obj;
	private V val;

	public SubGen(V val, T obj) {
		super(obj);
		this.obj = obj;
		this.val = val;
	}

	public T getObj() {
		return obj;
	}

	public V getVal() {
		return val;
	}
}
