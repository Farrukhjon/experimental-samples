package string;

import java.util.Calendar;
import java.util.Date;

public class Formatting {

	public static void main(String[] args) {

		Date date = Calendar.getInstance().getTime();

		System.out.println(String.format("date %tY-%tm-%td", date, date, date));

	}

}
