package object;

public class NullParam {

	public NullParam(Object obj) {
		if (obj != null)
			System.out.println(obj.getClass().getSimpleName());
		else
			System.out.println("obj param is null");
	}

	public NullParam(double[] arr) {
		if (arr != null)
			System.out.println(arr.getClass().getSimpleName());
		else
			System.out.println("arr param is null");
	}

	public static void main(String[] args) {
		new NullParam(null);
	}

}
