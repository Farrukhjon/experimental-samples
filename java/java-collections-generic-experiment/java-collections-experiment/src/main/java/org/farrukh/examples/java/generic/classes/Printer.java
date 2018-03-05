package org.farrukh.examples.java.generic.classes;

public class Printer<T extends ICartridge> {

	private T cartridge;

	public Printer(T cartridge) {
		this.cartridge = cartridge;
	}

	public void print() {
		System.out.println(cartridge.toString());
	}

	public <U extends ICartridge> void pringUsingCartridge(U cartridge) {
		System.out.println(cartridge.toString());
	}
}
