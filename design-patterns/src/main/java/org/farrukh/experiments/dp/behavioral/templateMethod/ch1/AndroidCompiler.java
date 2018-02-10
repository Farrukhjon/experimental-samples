package org.farrukh.experiments.dp.behavioral.templateMethod.ch1;

public class AndroidCompiler extends CrossCompiler {

	@Override
	protected void collectSource() {
		System.out.println("Android specific collect");
	}

	@Override
	protected void compileToTarget() {
		System.out.println("Android specific compile");
	}

}
