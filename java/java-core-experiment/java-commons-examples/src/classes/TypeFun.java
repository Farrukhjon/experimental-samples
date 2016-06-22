package classes;

public class TypeFun {

	public static void main(String[] args) {
		// public static final Class<Double> TYPE =
		// (Class<Double>)Class.getPrimitiveClass("double");
		System.out.println("Double.TYPE == double.class: " + (Double.TYPE == double.class));
		System.out.println("Double.TYPE == Double.class: " + (Double.TYPE == Double.class));
		System.out.println("double.class.isAssignableFrom(Double.class): " + (double.class.isAssignableFrom(Double.class)));
		System.out.println("Double.class.isAssignableFrom(double.class): " + (Double.class.isAssignableFrom(double.class)));
	}
}
