package org.farrukh.experiments.dp.behavioral.memento.ch1;

public class Originator {

	private String	article;

	public Momento storeInMomento() {
		return new Momento(article);
	}

	public String restoreFromMomento(Momento momento) {
		return momento.getSavedArticle();
	}

	public void setArticle(String newArticle) {
		this.article = newArticle;
	}
}
