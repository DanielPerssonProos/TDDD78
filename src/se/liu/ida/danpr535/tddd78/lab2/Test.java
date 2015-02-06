package se.liu.ida.danpr535.tddd78.lab2;

import java.time.LocalDate;

/**
 * Created by Daniel on 2015-01-26.
 */
public class Test {
    public static void main(String[] args) {
        testCalendar();
        //testStack();
    }
    private static void testCalendar(){
        Calendar myCalendar = new Calendar();
        myCalendar.book(2016, "January", 13, "12:30", "13:00", "Möte med handledare");
        myCalendar.book(2015, "February",24, "11:35", "12:05", "Handla");
        myCalendar.book(2015, "February", 6, "12:15", "13:00", "Lunchföreläsning");
        myCalendar.book(2015, "March", 8, "13:15", "13:30", "Shopping");
        myCalendar.book(2015, "May", 19, "19:35", "23:35", "Läkarbesök");
        myCalendar.show();
    }
    private static void testStack(){
        Stack myStack = new Stack();
        Person daniel = new Person("Daniel", LocalDate.of(1993, 4, 19));
        Person johanna = new Person("Johanna", LocalDate.of(1993,2,18));
        Person albin = new Person("Albin", LocalDate.of(1993,5,24));
        Person erik = new Person("Erik", LocalDate.of(1995,3,12));
        Person sebastian = new Person("Sebastian", LocalDate.of(1993,5,23));

        System.out.println(myStack);
        myStack.push(daniel);
        System.out.println(myStack);
        myStack.push(johanna);
        System.out.println(myStack);
        myStack.push(albin);
        System.out.println(myStack);
        myStack.push(erik);
        System.out.println(myStack);
        myStack.push(sebastian);

        System.out.println(myStack);
        while (myStack.size() > 0){
            myStack.pop();
            System.out.println(myStack);
        }
    }

}
