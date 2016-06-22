package org.farrukh.examples.patterns.creational.prototype.ch1;

public class CloneFactory {
	public IPrototype makeClone(IPrototype prototype) {
		return prototype.cloneObject();
	}
}
