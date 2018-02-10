package org.farrukh.experiments.dp.structural.flyweight.ch1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MyRectangle implements MyShape {

	private String label;

	public MyRectangle(String label) {
		this.label = label;

	}

	public void draw(Graphics rectangle, int x, int y, int width, int height,
			Color color, boolean fill, String font) {
		rectangle.setColor(color);
		rectangle.drawRect(x, y, width, height);
		rectangle.setFont(new Font(font, 12, 12));
		rectangle.drawString(label, x + (width / 2), y);
		if (fill)
			rectangle.fillRect(x, y, width, height);
	}
}
