package string;

public class CreateStringDemo {

	public static void main(String[] args) {

		String strDefault = new String();
		System.out.println(strDefault + strDefault.isEmpty());

		byte[] b = { 67, 32, 68, 69, 99, 100 };
		String strByte = new String(b);
		System.out.println(strByte);

		char[] ch = { 's', 'd', 'e', 'q', '2' };
		String strChar = new String(ch);
		System.out.println(strChar);

		StringBuffer buffer = new StringBuffer();
		buffer.append(ch);
		String strBuff = new String(buffer);
		System.out.println(strBuff);

		StringBuilder builder = new StringBuilder();
		builder.append("str");
		String strBuilder = new String(builder);
		System.out.println(strBuilder);
	}
}
