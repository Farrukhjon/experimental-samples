package org.farrukh.experiments.dp.behavioral.chain.ch1;

public class ZeroProcessor implements IChain {

	private IChain	nextInChain;

	public void process(Number request) {
		if (request.getNumber() == 0) {
			System.out.println("ZeroProcessor : " + request.getNumber());
		} else {
			nextInChain.process(request);
		}
	}

	public void setNext(IChain nextInChain) {
		this.nextInChain = nextInChain;
	}

}
