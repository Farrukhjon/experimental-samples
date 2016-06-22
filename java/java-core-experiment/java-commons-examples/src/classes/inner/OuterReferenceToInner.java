package classes.inner;

public class OuterReferenceToInner {

	private int secret;
	
	public OuterReferenceToInner() {
		secret = 123;
	}

	class Inner {
		int getSecret(){
			return secret;
		}
	}
	
	Inner createInner(){
		return new Inner();
	}

	public static void main(String[] args) {
		OuterReferenceToInner outRef = new OuterReferenceToInner();
		System.out.println(outRef.createInner().getSecret());
	}
}
