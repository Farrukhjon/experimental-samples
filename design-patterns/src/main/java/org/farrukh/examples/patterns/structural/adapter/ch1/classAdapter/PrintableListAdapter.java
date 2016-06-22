package org.farrukh.examples.patterns.structural.adapter.ch1.classAdapter;

import java.util.List;

public class PrintableListAdapter extends PrintString implements IPrintableList {

	@Override
	public void printList(List<String> list) {
		String str = "";
		for (String s : list) {
			str += s + "\t";
		}
		pring(str);
	}
}
