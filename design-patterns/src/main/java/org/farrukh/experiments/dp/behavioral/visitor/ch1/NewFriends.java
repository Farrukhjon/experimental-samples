package org.farrukh.experiments.dp.behavioral.visitor.ch1;

public class NewFriends implements IFriend {

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

}
