package org.farrukh.experiments.dp.behavioral.memento.ch3;

public class Client {

	public static void main(String[] args) {

		IntAdder adder = new IntAdder();

		adder.setDataState(10);

		IntMemento memento = adder.save();

		System.out.println("saved data: " + adder);

		adder.setDataState(11);

		System.out.println("new added data: " + adder);

		adder.restore(memento);

		System.out.println("restore saved data: " + adder);
	}

}
