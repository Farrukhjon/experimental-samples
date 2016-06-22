package interfaces.inher;

public class Do2 extends ParentDo {
	@Override
	public void doSome() {
		super.doSome();
		System.out.println("do2 is an child of ParentDo that implements Able");
	}
}
