package interfaces.inher;

public class AbleDemo {

	public static void main(String[] args) {
		Able doN = new Do1();
		printDo(doN);
		doN = new Do2();
		printDo(doN);
	}
	
	private static void printDo(Able ab){
		ab.doSome();
	}
}
