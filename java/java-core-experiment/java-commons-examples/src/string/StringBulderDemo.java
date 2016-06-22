package string;


public class StringBulderDemo {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		sb.append("<ul class='").append("nav nav-palls'>");
		System.out.println(sb);
		
		StringBuffer redAsteriskHtml = new StringBuffer(200);
		redAsteriskHtml.append("<b style='").append("color:red;font-size:medium;'>*</b>");
		System.out.println(redAsteriskHtml);
	}

}
