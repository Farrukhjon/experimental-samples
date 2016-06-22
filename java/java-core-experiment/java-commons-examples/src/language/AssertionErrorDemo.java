package language;

public class AssertionErrorDemo {

	public static void main(String[] args) {
		
		AssertionErrorDemo ad = new AssertionErrorDemo();
		
		double z0 = ad.calc(2, 10);
		System.out.println(z0);
		double z1 = ad.calc(0, 10);
		System.out.println(z1);
		double z2 = ad.calc(10, 10);
		System.out.println(z2);
	}

	public double calc(int x, int y) {
		assert x != 0 : "Error, x must not be zero";
		double z = y / x;
		return z;
	}

}
