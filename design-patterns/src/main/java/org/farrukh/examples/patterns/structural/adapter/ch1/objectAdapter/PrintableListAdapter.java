package org.farrukh.examples.patterns.structural.adapter.ch1.objectAdapter;

import java.util.List;

public class PrintableListAdapter implements IPrintableList {

	PrintString	printString;

	public PrintableListAdapter() {
		printString = new PrintString();
	}

	public void printList(List<String> list) {
		String s = "";
		for (String str : list) {
			s += str + "\t";
		}
		printString.pring(s);
	}
}
