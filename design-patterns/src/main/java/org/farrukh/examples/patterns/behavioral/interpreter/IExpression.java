package org.farrukh.examples.patterns.behavioral.interpreter;

import java.util.Map;

public interface IExpression {

	public int interpret(Map<String, IExpression> variables);
}
