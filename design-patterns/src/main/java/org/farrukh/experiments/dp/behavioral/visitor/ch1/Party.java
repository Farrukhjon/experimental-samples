package org.farrukh.experiments.dp.behavioral.visitor.ch1;

public class Party implements IVisitor {

	private String	str;

	@Override
	public void visit(FriendsInHighSchool friends) {
		str = "FriendsInHighSchool";
	}

	@Override
	public void visit(FriendsFromNeighbour friends) {
		str = "FriendsFromNeighbour";
	}

	@Override
	public void visit(NewFriends friends) {
		str = "NewFriends";
	}

	@Override
	public String toString() {
		return str;
	}
}
