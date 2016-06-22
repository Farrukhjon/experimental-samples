package org.farrukh.examples.patterns.structural.composite.ch1;

public class Client {

	public static void main(String[] args) {

		Ellipse ellipse1 = new Ellipse();
		Ellipse ellipse2 = new Ellipse();
		Ellipse ellipse3 = new Ellipse();
		
		Circle circle1 = new Circle();
		Circle circle2 = new Circle();
		Circle circle3 = new Circle();
		
		CompositeGraphic compositeGraphic0 = new CompositeGraphic();
		CompositeGraphic compositeGraphic1 = new CompositeGraphic();
		CompositeGraphic compositeGraphic2 = new CompositeGraphic();

		compositeGraphic1.add(ellipse1);
		compositeGraphic1.add(ellipse2);
		compositeGraphic2.add(ellipse3);

		compositeGraphic2.add(circle1);
		compositeGraphic2.add(circle2);
		compositeGraphic2.add(circle3);

		compositeGraphic0.add(compositeGraphic1);
		compositeGraphic0.add(compositeGraphic2);

		compositeGraphic0.print();
		compositeGraphic2.remove(ellipse3);
		System.out.println("------------");
		compositeGraphic0.print();

	}
}
