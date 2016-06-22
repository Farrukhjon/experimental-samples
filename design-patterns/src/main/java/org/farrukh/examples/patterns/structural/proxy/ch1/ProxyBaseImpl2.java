package org.farrukh.examples.patterns.structural.proxy.ch1;

public class ProxyBaseImpl2 implements ProxyBase{

	@Override
	public void taskOne() {
		System.out.println("implements2 taskOne");	
	}

	@Override
	public void taskThree() {
		System.out.println("implements2 taskTree");		
	}

	@Override
	public void taskTwo() {
		System.out.println("implements2 taskTwo");		
	}
}
