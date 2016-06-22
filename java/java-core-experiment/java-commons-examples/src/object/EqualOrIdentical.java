package object;

public class EqualOrIdentical {

	private int id;
	
	public EqualOrIdentical(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EqualOrIdentical other = (EqualOrIdentical) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	public static void main(String[] args) {
		
		String foo = "A";
		String bar = "A";
		
		final boolean isIdentical = (foo == bar);
		System.out.println(isIdentical);
		final boolean isEquals = foo.equals(bar);
		System.out.println(isEquals);
		
		EqualOrIdentical eoiFoo = new EqualOrIdentical(1);
		EqualOrIdentical eoiBar = new EqualOrIdentical(1);
		
		final boolean isIdent = (eoiFoo == eoiBar);
		System.out.println(isIdent);
		final boolean isequals = eoiFoo.equals(eoiBar);
		System.out.println(isequals);
		System.out.println(eoiFoo);
		System.out.println(eoiBar);
	}
	

}
