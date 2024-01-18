package se.liu.noalj314.calendar;

import java.util.Map;

public class Month
{
    private String name;
    private int number;
    private int days;
    private final static Map<String,Integer> MONTH_NAME_TO_LENGTH = Map.ofEntries(
	    Map.entry("January", 31), Map.entry("February", 28), Map.entry("March", 31), Map.entry("April", 30), Map.entry("May", 31),
	    Map.entry("June", 30), Map.entry("July", 31), Map.entry("August", 31), Map.entry("September", 30), Map.entry("October", 31),
	    Map.entry("November", 30), Map.entry("December", 31)
    );
    private final static Map<String,Integer> MONTH_NAME_TO_NUMBER= Map.ofEntries(
	    Map.entry("January", 1), Map.entry("February", 2), Map.entry("March", 3), Map.entry("April", 4), Map.entry("May", 5),
	    Map.entry("June", 6), Map.entry("July", 7), Map.entry("August", 8), Map.entry("September", 9), Map.entry("October", 10),
	    Map.entry("November", 11), Map.entry("December", 12)
    );
    public Month(final String name, final int number, final int days) {
	this.name = name;
	this.number = number;
	this.days = days;
    }
    public static boolean isMonthValid(String month) {
	return MONTH_NAME_TO_NUMBER.containsKey(month);
    }
    public String getName() {
	return name;
    }

    public int getNumber() {
	return number;
    }

    public int getDays() {
	return days;
    }
    public static int getMonthNumber(String name) {
	return MONTH_NAME_TO_NUMBER.getOrDefault(name, -1);
    }
    public static int getMonthDays(String name){
	return MONTH_NAME_TO_LENGTH.getOrDefault(name, -1);
    }

    public static void main(String[] args) {
	System.out.println(Month.getMonthNumber("April"));
	System.out.println(Month.getMonthDays("April"));
    }
}

