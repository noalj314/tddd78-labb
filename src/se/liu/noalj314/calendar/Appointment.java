package se.liu.noalj314.calendar;

public class Appointment
{
    private String subject;
    private SimpleDate date;
    private TimeSpan timespan;

    public Appointment(final String subject, final SimpleDate date, final TimeSpan timespan) {
	this.subject = subject;
	this.date = date;
	this.timespan = timespan;
    }
    public String getSubject() {
	return subject;
    }
    public SimpleDate getDate() {
	return date;
    }
    public TimeSpan getTimespan() {
	return timespan;
    }

    @Override public String toString() {
	return subject + " " + date + " " + timespan;
    }

    public static void main(String[] args) {
	TimePoint start = new TimePoint(9, 5);
	TimePoint end = new TimePoint(10, 5);
	TimeSpan newTimeSpan = new TimeSpan(start, end);
	Month newMonth = new Month("April", 4, 30);
	SimpleDate newDate = new SimpleDate(2000, newMonth, 10);
	Appointment newApp = new Appointment("Programmering", newDate, newTimeSpan);
	System.out.println(newApp);
    }
}
