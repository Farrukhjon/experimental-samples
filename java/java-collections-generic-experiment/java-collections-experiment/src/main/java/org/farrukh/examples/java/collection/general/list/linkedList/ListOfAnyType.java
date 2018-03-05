package org.farrukh.examples.java.collection.general.list.linkedList;

import java.util.ArrayList;
import java.util.List;

public class ListOfAnyType {

	public static void main(String[] args) {

		List<?> listOfAnyType = null;
		
		List<Object> listObjects = new ArrayList<Object>();
		List<String> listStrings = new ArrayList<String>();
		List<Integer> listIntegers = new ArrayList<Integer>();

		listOfAnyType = listObjects;
		listOfAnyType = listStrings;
		listOfAnyType = listIntegers;

		/*listObjects = listStrings; 
		 * Exception in thread "main" java.lang.Error: Unresolved compilation problem:  
		 * Type mismatch: cannot convert from List<String> to List<Object>
		*/
	}

}
