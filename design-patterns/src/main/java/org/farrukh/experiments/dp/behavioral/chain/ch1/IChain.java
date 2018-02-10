package org.farrukh.experiments.dp.behavioral.chain.ch1;

public interface IChain {

	public abstract void process(Number request);

	public abstract void setNext(IChain nextInChain);

}
