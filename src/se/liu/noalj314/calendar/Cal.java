package se.liu.noalj314.calendar;

import java.util.ArrayList;
import java.util.List;

public class Cal
{
    private List<Appointment> appointments;

    public Cal() {
	appointments = new ArrayList<>();
    }

    public void show() {
	for (Appointment appointment : appointments) {
	    System.out.println(appointment);

	    }
	}

    public void book(int year, String month, int day, int startHour, int startMinute, int endHour,
		     int endMinute, String subject) {
	if (isaBoolean(year, month, startHour, startMinute, endHour, endMinute, day)) {
	    	TimePoint startTimePoint = new TimePoint(startHour, startMinute);
		TimePoint endTimePoint = new TimePoint(endHour, endMinute);
		TimeSpan timespan = new TimeSpan(startTimePoint, endTimePoint);
		Month mon = new Month(month, Month.getMonthNumber(month),Month.getMonthDays(month));
		SimpleDate date = new SimpleDate(year, mon, day);
		Appointment app = new Appointment(subject, date, timespan);
		appointments.add(app);
	}
	else {
	    throw new IllegalArgumentException("felmeddelande");
	}

    }

    private static boolean isaBoolean(int year, String month, int startHour, int startMinute, int endHour,
				       int endMinute, int day)
    {
	return year > 1970 && startHour <= 23 && startHour >= 0 && startMinute <= 59 && startMinute >= 0 && Month.isMonthValid(month) &&
	       endHour >= 0 && endHour <= 23 && endMinute <= 59 && endMinute >= 0 && day <= Month.getMonthDays(month);
    }
    public static void main(String[] args) {

    }
}
