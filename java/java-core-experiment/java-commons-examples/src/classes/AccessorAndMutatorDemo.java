package classes;

public class AccessorAndMutatorDemo {

	// Mutable fields
	private String				str;
	private int					ineger;
	private double				dbl;

	// Immutable field i.e. constant
	public static final String	VAR	= "value";

	// Accessor methods
	public String getStr() {
		return str;
	}

	public int getIneger() {
		return ineger;
	}

	public double getDbl() {
		return dbl;
	}

	// Mutator methods
	public void setStr(String str) {
		this.str = str;
	}

	public void setIneger(int ineger) {
		this.ineger = ineger;
	}

	public void setDbl(double dbl) {
		this.dbl = dbl;
	}

}
