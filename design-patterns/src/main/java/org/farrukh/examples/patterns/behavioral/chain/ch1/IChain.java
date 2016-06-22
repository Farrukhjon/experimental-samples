package org.farrukh.examples.patterns.behavioral.chain.ch1;

public interface IChain {

	public abstract void process(Number request);

	public abstract void setNext(IChain nextInChain);

}
