package language;

public class LocaleVariable {

	String	phoneNumber	= "1234567890";

	public void setPhoneNumber() {
		String phoneNumber;
		phoneNumber = "0987654321";
	}

	public static void main(String[] args) {
		LocaleVariable variable = new LocaleVariable();
		variable.setPhoneNumber();
		System.out.println(variable.phoneNumber);
	}

}
