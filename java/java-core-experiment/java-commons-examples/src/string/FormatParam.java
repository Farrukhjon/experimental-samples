package string;

public class FormatParam {

	public static void main(String[] args) {
		System.out.println(execute("div", new Object()));
	}

	public static String execute(String script, Object... params) {
		return "(function($) { " + String.format(script, params) + " })(jQuery);";
	}

}
