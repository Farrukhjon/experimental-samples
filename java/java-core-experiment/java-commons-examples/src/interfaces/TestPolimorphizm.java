package interfaces;

public class TestPolimorphizm {

	public static void main(String[] args) {
		Shape shape1 = new Circle();
		//myDrawMethod(shape1);
		Shape shape2 = new Triangle();
		//myDrawMethod(shape2);
		Drawing drawing = new Drawing();
		drawing.setShape(shape1);
		drawing.drawShape();
		drawing.setShape(shape2);
		drawing.drawShape();
	}

	protected static void myDrawMethod(Shape shape) {
		shape.draw();
	}
}
