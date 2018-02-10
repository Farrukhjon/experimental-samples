package org.farrukh.experiments.dp.behavioral.observer.ch1;

/**
 * @author Farrukhjon SATTOROV
 */
public class User implements Observer {

	private String	article;
	private Subject	blog;

	public String getArticle() {
		return article;
	}

	public void setSubject(Subject subject) {
		this.blog = subject;
		article = "No New Article!";
	}

	public void update() {
		System.out.println("State change reported by Subject.");
		article = (String) blog.getUpdate();
	}
}
