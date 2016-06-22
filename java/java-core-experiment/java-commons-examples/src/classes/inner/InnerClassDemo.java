package classes.inner;

public class InnerClassDemo {
	
	public static void main(String[] args){
		System.out.println(new InnerClassDemo().new InnerClass().getHello());
	}
	
	private class InnerClass {
		String getHello(){
			return "Hello";
		}
	}
}
