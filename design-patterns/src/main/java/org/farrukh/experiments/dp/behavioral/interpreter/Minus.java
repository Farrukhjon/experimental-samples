package org.farrukh.experiments.dp.behavioral.interpreter;

import java.util.Map;

public class Minus implements IExpression {

	private IExpression	leftOperand;
	private IExpression	rightOperand;

	public Minus(IExpression leftOperand, IExpression rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	@Override
	public int interpret(Map<String, IExpression> variables) {
		return leftOperand.interpret(variables) - rightOperand.interpret(variables);
	}

}
