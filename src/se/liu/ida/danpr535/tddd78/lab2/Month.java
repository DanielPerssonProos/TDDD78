package se.liu.ida.danpr535.tddd78.lab2;

/**
 * Created by Daniel on 2015-01-22.
 */
public class Month {
    private String name;
    private int number;
    private int days;

    public Month(String name) {
        this.name = name;
        this.number = getMonthNumber(this.name);
        this.days = getMonthDays(this.name);
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

    public static int getMonthNumber(String name){
        switch(name){
            case "January":
                return 1;
            case "February":
                return 2;
            case "March":
                return 3;
            case "April":
                return 4;
            case "May":
                return 5;
            case "June":
                return 6;
            case "July":
                return 7;
            case "August":
                return 8;
            case "September":
                return 9;
            case "October":
                return 10;
            case "November":
                return 11;
            case "December":
                return 12;
            default:
                System.out.println("The month entered is not valid.");
                return -1;
        }
    }

    public static int getMonthDays(String name){
        switch(name) {
            case "January":
                return 31;
            case "February":
                return 28;
            case "March":
                return 31;
            case "April":
                return 30;
            case "May":
            case "July":
                return 31;
            case "June":
                return 30;
            case "August":
                return 31;
            case "September":
                return 30;
            case "October":
                return 31;
            case "November":
                return 30;
            case "December":
                return 31;
            default:
                System.out.println("The month entered is not valid.");
                return -1;
        }
    }

    public static boolean validate(String name){
        if (getMonthNumber(name) == -1 || getMonthDays(name) == -1){
            return false;
        } else{
            return true;
        }
    }
}
