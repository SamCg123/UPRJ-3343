package libsystem;
public class Day implements Cloneable {

	private int year;
	private int month;
	private int day;
	int[] sDayParts;
	private static final String MonthNames = "JanFebMarAprMayJunJulAugSepOctNovDec";

	// Constructor
	public Day(String sDay) {
		set(sDay);
	}

	public int[] returnday(){
		sDayParts[0] =this.day; 
		sDayParts[1] =this.month; 
		sDayParts[2] =this.year;
		return sDayParts; 
	}
	public void set(String sDay) 
	{
		String[] sDayParts = sDay.split("-");
		this.day = Integer.parseInt(sDayParts[0]); 
		this.year = Integer.parseInt(sDayParts[2]);
		this.month = Integer.parseInt(sDayParts[1]);
	}

	// Check if a given year is a leap year
	public static boolean isLeapYear(int y) {
		if (y % 400 == 0)
			return true;
		else if (y % 100 == 0)
			return false;
		else if (y % 4 == 0)
			return true;
		else
			return false;
	}

	// Check if y,m,d valid
	public static boolean valid(int y, int m, int d) {
		if (m < 1 || m > 12 || d < 1)
			return false;
		switch (m) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return d <= 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return d <= 30;
			case 2:
				if (isLeapYear(y))
					return d <= 29;
				else
					return d <= 28;
			default:
				return false;
		}
	}

	// Return a string for the day like dd MMM yyyy
	@Override
	public String toString() {
		return day + "-" + MonthNames.substring((month - 1) * 3, (month) * 3) + "-" + year; // (month-1)*3,(month)*3
	}

	@Override
	public Day clone() {
		Day copy = null;
		try {
			copy = (Day) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return copy;
	}

	public static boolean isEndOfAMonth(int[] date) {
		if (valid(date[2], date[1], date[0] + 1))
			return false;
		else
			return true;
	}

	public static int[] next(int[] date) {
		// 0 = Day, 1 = Month, 2 = Year
		if (isEndOfAMonth(date)) {
            if (date[2]==12) {
                date[2] ++;
                date[1] = 1;
                date[0] = 1;
				return date; 
            } else {
                date[1] ++;
                date[0] = 1;
                return date;
            }
        } else {
            date[0] += 1;
            return date;
        }
	}
}
