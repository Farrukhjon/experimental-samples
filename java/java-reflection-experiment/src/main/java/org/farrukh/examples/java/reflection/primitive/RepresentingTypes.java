/**
 * 
 */
package org.farrukh.examples.java.reflection.primitive;

import java.lang.reflect.Method;
import java.util.Vector;

/**
 * @author Farrukhjon SATTOROV, Dec 8, 2014
 *
 */
public class RepresentingTypes {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
		Method method = Vector.class.getMethod("get", int.class);
		System.out.println(method.toString());
		
		Method addAll = Vector.class.getMethod("copyInto", new Class[]{Object[].class});
		System.out.println(addAll.toGenericString());
	}

}
