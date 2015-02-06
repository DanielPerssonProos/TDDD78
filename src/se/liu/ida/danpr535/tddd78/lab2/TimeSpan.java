package se.liu.ida.danpr535.tddd78.lab2;

/**
 * Created by Daniel on 2015-01-22.
 */
public class TimeSpan {
    private TimePoint start;
    private TimePoint end;

    public TimeSpan(TimePoint start, TimePoint end) {
        this.start = start;
        this.end = end;
    }

    public TimePoint getStart() {
        return start;
    }

    public TimePoint getEnd() {
        return end;
    }
    public String toString(){
        return start + " - " + end;
    }
}



