package org.farrukh.experiments.dp.structural.proxy.ch1;

public class ProxyBaseImpl implements ProxyBase {

	@Override
	public void taskOne() {
		System.out.println("implements taskOne");	
	}

	@Override
	public void taskThree() {
		System.out.println("implements taskTree");		
	}

	@Override
	public void taskTwo() {
		System.out.println("implements taskTwo");		
	}
}
