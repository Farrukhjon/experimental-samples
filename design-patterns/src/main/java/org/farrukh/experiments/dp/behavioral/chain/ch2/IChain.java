package org.farrukh.experiments.dp.behavioral.chain.ch2;

public interface IChain {
	
	public void setNextChain(IChain nextChain);
	
	public void calculate(Numbers request);
}
