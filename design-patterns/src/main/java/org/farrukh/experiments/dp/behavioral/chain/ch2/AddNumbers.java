package org.farrukh.experiments.dp.behavioral.chain.ch2;

public class AddNumbers implements IChain {

	private IChain	nextChain;

	@Override
	public void setNextChain(IChain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void calculate(Numbers request) {
		if (request.getCalcWanted().equals("add")) {
			System.out.println(request.getNumber1() + "+" + request.getNumber2() + "=" + (request.getNumber1() + request.getNumber2()));
		} else {
			nextChain.calculate(request);
		}
	}
}
