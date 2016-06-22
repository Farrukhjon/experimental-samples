/**
 * 
 */
package org.examples.java.date;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class LocalDateDemo {

	public static void main(String[] args) {
		final LocalDate now = LocalDate.now();
		System.out.println("LocalDate.now(): " + now);
		final LocalDate now2 = LocalDate.now(ZoneId.systemDefault());
	}
	
	
	
}
