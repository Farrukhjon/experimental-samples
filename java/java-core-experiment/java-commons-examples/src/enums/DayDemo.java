package enums;

public class DayDemo {

	private Day	day;

	public DayDemo(Day day) {
		this.day = day;
	}

	public void whatDay() {
		switch (day) {
			case MONDAY:
				System.out.println("To day is monday");
				break;
			case FRIDAY:
				System.out.println("Fridays are better.");
				break;
			case SATURDAY:
			case SUNDAY:
				System.out.println("Weekends are best.");
				break;
			default:
				System.out.println("Midweek days are so-so.");
				break;
		}
	}

	public static void main(String[] args) {
		DayDemo firstDay = new DayDemo(Day.MONDAY);
		firstDay.whatDay();
	}

}
