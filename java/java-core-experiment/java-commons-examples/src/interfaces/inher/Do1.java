package interfaces.inher;

public class Do1 extends ParentDo {
	
	@Override
	public void doSome() {
		super.doSome();
		System.out.println("do1 is an child of ParentDo that implements Able");
	}
}
