package se.liu.ida.danpr535.tddd78.lab2;

/**
 * Created by Daniel on 2015-01-22.
 */
public class Appointment {
    private String subject;
    private Date date;
    private TimeSpan timeSpan;

    public Appointment(String subject, Date date, TimeSpan timeSpan) {
        this.subject = subject;
        this.date = date;
        this.timeSpan = timeSpan;
    }

    public String getSubject() {
        return subject;
    }

    public Date getDate() {
        return date;
    }

    public TimeSpan getTimeSpan() {
        return timeSpan;
    }

    public String toString(){
        return date + " " + timeSpan + " " + subject;
    }
}
