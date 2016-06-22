package date.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CompareTwoDate {

	public static void main(String[] args) {

		System.out.println(isFutureDate("01-08-2012"));

	}

	private static boolean isFutureDate(String date) {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date curDate = null;
		Date testDate = null;
		try {
			curDate = df.parse(df.format(Calendar.getInstance().getTime()));
			testDate = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (curDate.compareTo(testDate) == -1)
			return true;
		return false;
	}
}
