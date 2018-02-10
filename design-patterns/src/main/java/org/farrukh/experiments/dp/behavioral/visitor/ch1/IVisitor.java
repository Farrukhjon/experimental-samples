package org.farrukh.experiments.dp.behavioral.visitor.ch1;

public interface IVisitor {

	public void visit(FriendsInHighSchool friends);

	public void visit(FriendsFromNeighbour friends);

	public void visit(NewFriends friends);
}
