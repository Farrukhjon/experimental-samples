package org.farrukh.experiments.dp.behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

public class Client {

	public static void main(String[] args) {

		String expression = "w x z - +";
		
		Evaluator sentence = new Evaluator(expression);
		
		Map<String, IExpression> variables = new HashMap<String, IExpression>();
		
		variables.put("w", new InterpretNumber(5));
		variables.put("x", new InterpretNumber(10));
		variables.put("z", new InterpretNumber(42));
		
		int result = sentence.interpret(variables);
		System.out.println(result);
	}

}
