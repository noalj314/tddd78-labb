package se.liu.noalj314.lab1;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String name;
    private LocalDate birthDay;
    public Person(String name, LocalDate birthDay) {
	this.name = name;
	this.birthDay = birthDay;
    }
    public String getName() {
	return name;
    }
    public LocalDate getBirthDay() {
	return birthDay;
    }
    public int getAge() {
	return Period.between(birthDay, LocalDate.now()).getYears();
    }

    @Override public String toString() {
	return name + " " + getAge();
    }

    public static void main(String[] args) {
	LocalDate myBirthDay = LocalDate.of(1970, 10, 10);
	LocalDate dwightsBirthDay = LocalDate.of(1900, 10, 10);
	Person michael = new Person("Michael Scott", myBirthDay);
	Person dwight = new Person("Dwight Schrute", dwightsBirthDay);
	Person jim = new Person("Jim Halpert", myBirthDay);
	System.out.println(michael);
	System.out.println(dwight);
	System.out.println(jim);
    }

}
