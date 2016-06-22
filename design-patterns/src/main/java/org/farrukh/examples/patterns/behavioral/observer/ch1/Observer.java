/**
 * 
 */
package org.farrukh.examples.patterns.behavioral.observer.ch1;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public interface Observer {
	
	public void setSubject(Subject subject);
	
	public void update();

}
