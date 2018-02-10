package org.farrukh.experiments.dp.behavioral.interpreter;

import java.util.Map;
import java.util.Stack;

public class Evaluator implements IExpression {

	private IExpression	syntaxTree;

	public Evaluator(String expression) {
		Stack<IExpression> expressionStack = new Stack<IExpression>();
		for (String token : expression.split(" ")) {
			if (token.equals("+")) {
				IExpression subIExpression = new Plus(expressionStack.pop(), expressionStack.pop());
				expressionStack.push(subIExpression);
			} else if (token.equals("-")) {
				// it's necessary remove first the right operand from the stack
				IExpression right = expressionStack.pop();
				// ..and after the left one
				IExpression left = expressionStack.pop();
				IExpression subIExpression = new Minus(left, right);
				expressionStack.push(subIExpression);
			} else
				expressionStack.push(new Variable(token));
		}
		syntaxTree = expressionStack.pop();
	}

	@Override
	public int interpret(Map<String, IExpression> variables) {
		return syntaxTree.interpret(variables);
	}

}
