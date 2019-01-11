package org.farrukh.examples.exceptions.runtimeException;

public class TwistInTaleNullPointerException {

	public static void main(String[] args) {
		
		String[][] oldLaptops = { { "Dell", "Toshiba", "Vaio" }, null, { "IBM" }, new String[10] };
	
		System.out.println(oldLaptops[0][0]); // line 1
		System.out.println(oldLaptops[1]); // line 2
		System.out.println(oldLaptops[3][6]); // line 3
		System.out.println(oldLaptops[3][0].length()); // thrown NullPointerException line 4
		System.out.println(oldLaptops); // line 5
	}

}
