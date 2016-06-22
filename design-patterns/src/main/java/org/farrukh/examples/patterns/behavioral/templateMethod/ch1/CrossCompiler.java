package org.farrukh.examples.patterns.behavioral.templateMethod.ch1;

public abstract class CrossCompiler {

	public final void crossCompile() {
		collectSource();
		compileToTarget();
	}

	// Template methods
	protected abstract void collectSource();

	protected abstract void compileToTarget();

	// hook method
	protected boolean testEnvironment() {
		return false;
	}
}
