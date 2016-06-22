package bit;

public class UnsginedToByte {

	public static void main(String[] args) {
		for(int i = -127; i <= 127; i++){
			int v = signedToByte((byte) i);
			System.out.printf("%-4s,", v);
		}
		System.out.println("\n-------------------------");
		for(int i = -127; i <= 127; i++){
			int v = unsignedToByte((byte) i);
			System.out.printf("%-4s,", v);
		}
	}

	private static int unsignedToByte(byte b) {
		return b & 0xff;
	}

	private static int signedToByte(byte b) {
		return b ;
	}

}
