package org.farrukh.experiments.dp.structural.flyweight.ch1;

import java.util.HashMap;

public class ShapeFactory {

	private static final HashMap<String, MyShape> shapes	= new HashMap<String, MyShape>();

	public static MyShape getShape(String label) {

		MyShape concreteShape = (MyShape) shapes.get(label);

		if (concreteShape == null) {
			if (label.equals("R")) {
				concreteShape = new MyRectangle(label);
			} else if (label.equals("O")) {
				concreteShape = new MyOval(label);
			}
			shapes.put(label, concreteShape);
		}
		return concreteShape;
	}
}
