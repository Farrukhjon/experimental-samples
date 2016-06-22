package org.farrukh.examples.java.generic.classes;

public class PrinterDemo {

	public static void main(String[] args) {
		Printer<ColorCartridge> printer = new Printer<ColorCartridge>(new ColorCartridge());
		printer.print();
		Printer<BWCartridge> printer1 = new Printer<BWCartridge>(new BWCartridge());
		printer1.print();
		printer.pringUsingCartridge(new ColorCartridge());
	}
}
