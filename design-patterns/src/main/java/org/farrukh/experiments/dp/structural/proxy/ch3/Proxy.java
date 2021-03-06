/**
 * File generated from the Patterns::proxy::Proxy uml Class
 * Generated by the Acceleo 3 <i>UML to Java</i> generator.
 */
package org.farrukh.experiments.dp.structural.proxy.ch3;

// End of user codes

/**
 * Description of Proxy.
 */
public class Proxy implements Subject {
	public RealSubject	realSubject	= null;

	public Proxy() {
		super();
	}

	public void doOperation() {

	}

	public RealSubject getRealSubject() {
		return this.realSubject;
	}

	public void setRealSubject(RealSubject newRealSubject) {
		this.realSubject = newRealSubject;
	}

}
