package se.liu.ida.danpr535.tddd78.lab2;

/**
 * Created by Daniel on 2015-01-22.
 */
public class Date {
    private int year;
    private Month month;
    private int day;

    public Date(int year, Month month, int day) {
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

    public String toString(){
        String mon;
        String dag;
        if (this.month.getNumber() < 10){
            mon = "0" + Integer.toString(this.month.getNumber());
        } else mon = Integer.toString(this.month.getNumber());
        if (day < 10){
            dag = "0" + Integer.toString(day);
        } else { dag = Integer.toString(day);}

        return dag +'-' + mon + '-'
                + Integer.toString(this.year);
    }
}
