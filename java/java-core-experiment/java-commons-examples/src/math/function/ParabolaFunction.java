package math.function;

public class ParabolaFunction {

	private int			left;
	private int			right;
	private double[]	value;
	private double[]	domain	= new double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0 };

	public ParabolaFunction(int left, int right) {
		this.left = left;
		this.right = right;
		value = new double[right + 1];
	}

	public double[] calculate() {
		for (int i = left; i <= right; i++) {
			double val = domain[i];
			value[i] = Math.pow(val, 2);
		}
		return value;
	}

	public void print() {
		for (double val : value) {
			System.out.print(" " + val);
		}
	}

	public void setDomain(double[] domain) {
		this.domain = domain;
	}

	public static void main(String[] args) {

		ParabolaFunction parabolaFunction = new ParabolaFunction(0, 9);
		parabolaFunction.calculate();
		parabolaFunction.print();
	}

}
