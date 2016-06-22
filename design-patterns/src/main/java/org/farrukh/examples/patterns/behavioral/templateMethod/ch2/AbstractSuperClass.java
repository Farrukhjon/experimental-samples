package org.farrukh.examples.patterns.behavioral.templateMethod.ch2;

public abstract class AbstractSuperClass {

	public final void templateMathod() {

		primitiveMethod1();
		primitiveMethod1();

		if (needHookMethod()) {
			// do something
		}
	}

	abstract void primitiveMethod1();

	abstract void primitiveMethod2();

	protected boolean needHookMethod() {
		return false;
	}
	
}
