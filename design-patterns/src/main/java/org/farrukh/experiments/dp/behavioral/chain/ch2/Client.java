package org.farrukh.experiments.dp.behavioral.chain.ch2;

public class Client {

	public static void main(String[] args) {

		IChain calcChain1 = new AddNumbers();
		IChain calcChain2 = new SubstractNumbers();
		IChain calcChain3 = new MultNumbers();
		IChain calcChain4 = new DivideNumbers();

		calcChain1.setNextChain(calcChain2);
		calcChain2.setNextChain(calcChain3);
		calcChain3.setNextChain(calcChain4);
		calcChain4.setNextChain(calcChain1);

		Numbers request = new Numbers(10, 2, "div");
		calcChain1.calculate(request);

		Numbers request1 = new Numbers(10, 2, "mult");
		calcChain1.calculate(request1);
	}

}
