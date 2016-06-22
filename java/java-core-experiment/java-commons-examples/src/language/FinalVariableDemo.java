package language;

public class FinalVariableDemo {

	private final Integer	intField	= 10;
	private Integer			notFinalInt	= 12;

	public FinalVariableDemo() {
		printFinal(intField);
		printFinal(notFinalInt);
	}

	private void printFinal(final Integer finalParam) {
		System.out.println(finalParam);
	}

	public static void main(String[] args) {
		new FinalVariableDemo();
	}

}
