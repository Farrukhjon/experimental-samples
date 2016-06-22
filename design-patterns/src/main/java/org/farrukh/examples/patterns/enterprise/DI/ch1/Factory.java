package org.farrukh.examples.patterns.enterprise.DI.ch1;

import org.farrukh.examples.patterns.enterprise.DI.ch1.behavior.IAInterface;
import org.farrukh.examples.patterns.enterprise.DI.ch1.behavior.IBInterface;
import org.farrukh.examples.patterns.enterprise.DI.ch1.behavior.ICInterface;
import org.farrukh.examples.patterns.enterprise.DI.ch1.impl.AImpl;
import org.farrukh.examples.patterns.enterprise.DI.ch1.impl.BImpl;
import org.farrukh.examples.patterns.enterprise.DI.ch1.impl.CImpl;

public class Factory {

	public ClientClass getClientClass() {
		return new ClientClass(new AImpl(), new BImpl(), new CImpl());
	}

	public ClientClass getClientClass(IAInterface ia, IBInterface ib, ICInterface ic) {
		return new ClientClass(ia, ib, ic);
	}
}
