package se.liu.ida.danpr535.tddd78.lab2;

/**
 * Created by Daniel on 2015-01-22.
 */
public class TimePoint {
    private String time;
    private int hour;
    private int minute;

    public TimePoint(String time) {
        this.time = time;
        String[] parts = time.split(":");
        this.hour = Integer.parseInt(parts[0]);
        this.minute = Integer.parseInt(parts[1]);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String toString(){
        return this.time;
    }

    public static boolean validate(String time){
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        if (0<=hour && hour<=23 && 0<=minute && minute <= 59){
                return true;
            }
        return false;
        }
    }

