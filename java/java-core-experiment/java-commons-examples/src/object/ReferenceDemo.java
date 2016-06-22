package object;

public class ReferenceDemo {

	public static void main(String[] args) {

		Object obj1 = new Object();
		Object obj2 = new Object();
		Object ref = new Object();

		System.out.println("ref address in memory: " + ref);

		ref = obj1;
		System.out.println("ref address point to obj1: " + ref);

		ref = obj2;
		System.out.println("ref address point to obj2: " + ref);
		
		obj1 = null;
		
		ref = obj1;
		System.out.println("ref address point to obj1: " + ref);

	}

}
