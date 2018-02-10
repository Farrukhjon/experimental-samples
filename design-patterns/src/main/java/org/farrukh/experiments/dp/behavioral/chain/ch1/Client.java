package org.farrukh.experiments.dp.behavioral.chain.ch1;

public class Client {

	public static void main(String[] args) {

		IChain negChain = new NegativeProcessor();
		IChain zeroChain = new ZeroProcessor();
		IChain posChain = new PositiveProcessor();

		negChain.setNext(zeroChain);
		zeroChain.setNext(posChain);
		posChain.setNext(negChain);

		negChain.process(new Number(99));
		negChain.process(new Number(-30));
		negChain.process(new Number(0));
		negChain.process(new Number(-1));
		negChain.process(new Number(-3));
		negChain.process(new Number(0));
		negChain.process(new Number(1));

	}
}
