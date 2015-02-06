package se.liu.ida.danpr535.tddd78.lab2;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by Daniel on 2015-01-20.
 */
public class Person {
    private String name;
    private LocalDate BirthDay;


    @Override
    public String toString() {
        return name+" "+this.getAge();
    }


    public Person(String name, LocalDate BirthDay) {
        this.name = name;
        this.BirthDay = BirthDay;
    }

    public static void main(String[] args) {
        Person daniel = new Person("Daniel", LocalDate.of(1993, 4, 19));
        Person johanna = new Person("Johanna", LocalDate.of(1993,2,18));
        Person albin = new Person("Albin", LocalDate.of(1993,5,24));
        System.out.println(daniel);
        System.out.println(johanna);
        System.out.println(albin);
    }

    public int getAge() {
        return Period.between(this.BirthDay, LocalDate.now()).getYears();
    }
}
