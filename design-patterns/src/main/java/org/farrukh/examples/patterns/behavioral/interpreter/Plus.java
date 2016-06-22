package org.farrukh.examples.patterns.behavioral.interpreter;

import java.util.Map;

public class Plus implements IExpression {

	private IExpression	leftOperand;
	private IExpression	rightOperand;

	public Plus(IExpression leftOperand, IExpression rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	@Override
	public int interpret(Map<String, IExpression> variables) {
		return leftOperand.interpret(variables) + rightOperand.interpret(variables);
	}

}
