package se.liu.noalj314.calendar;

import java.sql.Time;

public class TimeSpan
{
    private TimePoint start;
    private TimePoint end;

    public TimeSpan(final TimePoint start, final TimePoint end) {
	this.start = start;
	this.end = end;
    }

    public TimePoint getStart() {
	return start;
    }

    public TimePoint getEnd() {
	return end;
    }

    @Override public String toString() {
	return start + " - " + end;
    }

    public static void main(String[] args) {
	TimePoint start = new TimePoint(9, 5);
	TimePoint end = new TimePoint(10, 5);
	TimeSpan newTS = new TimeSpan(start, end);
	System.out.println(newTS);
    }
}
