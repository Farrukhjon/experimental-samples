package org.farrukh.experiments.dp.behavioral.memento.ch2;

public class Client {

	public static void main(String[] args) {

		Editor editor = new Editor();
		editor.setState("init");
		System.out.println("Initial state: " + editor.getState());

		EditorMemento saved = editor.save();
		editor.setState("changed");
		System.out.println("New state:" + editor.getState());

		editor.restoreToState(saved);
		System.out.println("Restored state:" + editor.getState());
	}
}
