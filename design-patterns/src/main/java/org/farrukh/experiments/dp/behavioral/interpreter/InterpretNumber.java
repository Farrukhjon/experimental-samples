package org.farrukh.experiments.dp.behavioral.interpreter;

import java.util.Map;

public class InterpretNumber implements IExpression {

	private int	number;

	public InterpretNumber(int number) {
		super();
		this.number = number;
	}

	@Override
	public int interpret(Map<String, IExpression> variables) {
		return number;
	}

}
