package classes;

public final class ImmutableClass {

	private final String	str;
	private final int		count;

	private ImmutableClass(String str, int count) {
		this.str = str;
		this.count = count;
	}

	public static ImmutableClass newInstance(String str, int count) {
		return new ImmutableClass(str, count);
	}

	public String getStr() {
		return str;
	}

	public int getCount() {
		return count;
	}

}
