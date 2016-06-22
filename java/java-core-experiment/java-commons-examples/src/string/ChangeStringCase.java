package string;

public class ChangeStringCase {

	public static void main(String[] args) {

		String str = "StringDao".toLowerCase();
		String tstr = str.replace("d", "D");
		System.out.println(tstr);
		
		StringBuffer stringBuffer = new StringBuffer("StringDemo");
		System.out.println(stringBuffer.reverse());
		StringBuffer s = new StringBuffer(stringBuffer.substring(3));
		System.out.println(s.reverse());
		
		System.out.println(reformString("MaterialDao"));
		
	}
	
	private static String reformString(String str) {
		StringBuffer sb = new StringBuffer(str.toLowerCase());
		StringBuffer rsb = new StringBuffer(sb.reverse().substring(3));
		String result = rsb.reverse().toString() + "Dao";
		return result;
	}

}
