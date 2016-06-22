package org.farrukh.examples.patterns.behavioral.visitor.ch1;

public class FriendsFromNeighbour implements IFriend {

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

}
