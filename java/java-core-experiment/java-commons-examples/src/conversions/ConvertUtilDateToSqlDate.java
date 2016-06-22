package conversions;

public class ConvertUtilDateToSqlDate {

	public static void main(String[] args) {

		// contains both date and time information
		java.util.Date utilDate = new java.util.Date();
		System.out.println("Util date in Java : " + utilDate);

		// contains only date information without time
		final long time = utilDate.getTime();
		System.out.println("java.util.Date.getTime(): " + time);
		java.sql.Date sqlDate = new java.sql.Date(time);
		System.out.println("SQL date in Java : " + sqlDate);
		
		//System.out.printf("%d %d %d", sqlDate.getHours(), sqlDate.getMinutes(), sqlDate.getSeconds());
	}

}
