package org.farrukh.examples.patterns.behavioral.memento.ch2;

public class Editor {

	private String	editorContents;

	public void setState(String contents) {
		this.editorContents = contents;
	}

	public String getState() {
		return editorContents;
	}

	public EditorMemento save() {
		return new EditorMemento(editorContents);
	}

	public void restoreToState(EditorMemento memento) {
		editorContents = memento.getSavedState();
	}
}
