package se.liu.noalj314.calendar;

public class SimpleDate
{
    private int year;
    private Month month;
    private int day;

    public SimpleDate(int year, Month month, int day) {
	this.year = year;
	this.month = month;
	this.day = day;
    }

    public int getYear() {
	return year;
    }

    public Month getMonth() {
	return month;
    }

    public int getDay() {
	return day;
    }

    @Override public String toString() {
	return day + "th of " +  month.getName() + " " + year;
    }

    public static void main(String[] args) {
	Month newMonth = new Month("April", 4, 30);
	SimpleDate newDate = new SimpleDate(2000, newMonth, 10);
	System.out.println(newDate);
    }
}