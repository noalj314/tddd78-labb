package se.liu.noalj314.lab1;

public class Exercise10
{
    public static void main(String[] args) {
	int number = 16777217;
	float decimal = number;
	int integ = (int)decimal;
	int big = 2147483647;
	long bigger = (long)big + 1;
	System.out.println(number);
	System.out.println(decimal);
	System.out.println(integ);
	System.out.println(bigger);
    }
}
