package org.farrukh.experiments.dp.enterprise.DI.ch1;

import org.farrukh.experiments.dp.enterprise.DI.ch1.impl.AImpl;
import org.farrukh.experiments.dp.enterprise.DI.ch1.impl.BImpl;
import org.farrukh.experiments.dp.enterprise.DI.ch1.impl.CImpl;

public class Demo {

	public static void main(String[] args) {

		ClientClass clientClass = new Factory().getClientClass();
		clientClass.doSomeThing();

		clientClass = new Factory().getClientClass(new AImpl(), new BImpl(), new CImpl());
		clientClass.doSomeThing();
	}
}
