package org.farrukh.examples.patterns.behavioral.chain.ch2;

public class DivideNumbers implements IChain {

	private IChain	nextChain;

	@Override
	public void calculate(Numbers request) {
		if (request.getCalcWanted().equals("div")) {
			System.out.println(request.getNumber1() + "/" + request.getNumber2() + "=" + (request.getNumber1() / request.getNumber2()));
		} else {
			System.out.println("Only works with add, sub, multy and div operations");
		}
	}

	public IChain getNextChain() {
		return nextChain;
	}

	@Override
	public void setNextChain(IChain nextChain) {
		this.nextChain = nextChain;
	}


}
