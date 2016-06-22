package org.farrukh.examples.patterns.behavioral.templateMethod.ch1;

public class Client {

	public static void main(String[] args) {

		CrossCompiler iPhone = new IPhoneCompiler();
		iPhone.crossCompile();

		CrossCompiler android = new AndroidCompiler();
		android.crossCompile();
	}

}
