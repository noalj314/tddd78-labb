package se.liu.noalj314.calendar;

public class CalTest
{
    public static void main(String[] args) {
	Cal myCal = new Cal();
	myCal.book(2000, "April", 10, 20, 20, 21, 21, "Korvätning");
	myCal.book(2000, "April", 10, 21, 21, 22, 22, "Dammsuggning");
	myCal.book(2000, "December", 15, 00, 21, 22, 22, "Dammsuggning");
	//myCal.book(2000, "Februari", 30, 00, 21, 22, 22, "Dammsuggning");

	myCal.show();
    }

}
