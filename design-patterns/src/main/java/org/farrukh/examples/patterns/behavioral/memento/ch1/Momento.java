package org.farrukh.examples.patterns.behavioral.memento.ch1;

public class Momento {

	private String	article;

	public Momento(String article) {
		this.article = article;
	}

	public String getSavedArticle() {
		return article;
	}

}
