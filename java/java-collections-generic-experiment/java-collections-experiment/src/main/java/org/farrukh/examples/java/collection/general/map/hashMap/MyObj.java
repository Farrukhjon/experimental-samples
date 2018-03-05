package org.farrukh.examples.java.collection.general.map.hashMap;

public class MyObj {

	private int	id;

	public MyObj(int id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyObj other = (MyObj) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}

	public static void main(String[] args) {
		MyObj obj1 = new MyObj(1);
		MyObj obj2 = new MyObj(2);
		MyObj obj3 = new MyObj(3);
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());

	}

}
