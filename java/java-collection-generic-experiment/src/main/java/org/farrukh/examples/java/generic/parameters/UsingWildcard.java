package org.farrukh.examples.java.generic.parameters;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class UsingWildcard {

	public static void main(String[] args) {
		
		List<String> strList = Arrays.asList(new String[] { "One", "Two", "Three", "Four" });
		printList(strList);
		
		List<Character> charList = Arrays.asList(new Character[] { 'a', 'b', 'c', 'd' });
		printList(charList);
	}

	private static void printList(List<? extends Serializable> list) {
		for (Object num : list) {
			System.out.println(num);
		}
	}
	
	private class MyClass<T> {
		
		void print(final MyClass<? extends Number> a){
			System.out.println(a);
		}
	}
}
