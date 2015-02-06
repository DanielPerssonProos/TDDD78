package se.liu.ida.danpr535.tddd78.lab2;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Daniel on 2015-01-22.
 */
public class Calendar {
    private List<Appointment> appointments;


    public Calendar() {
        this.appointments = new ArrayList<>();
    }

    public void show(){
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }
    public void book(int year, String month, int day,
                     String start, String end, String subject){

        if (year < 2015) throw new IllegalArgumentException("Felaktigt årtal");
        if (!TimePoint.validate(start)||!TimePoint.validate(end)) {
            throw new IllegalArgumentException("Felaktig start/sluttid.");
        }
        if (!Month.validate(month)) {
            throw new IllegalArgumentException("Felaktigt månadsnamn.");
        }
        if (!(day <= Month.getMonthDays(month))){
            throw new IllegalArgumentException("Månaden du har valt har inte så många dagar.");
        }
        TimeSpan meetingSpan = new TimeSpan(new TimePoint(start), new TimePoint(end));

        Appointment appointment = new Appointment(subject, new Date(year, new Month(month), day), meetingSpan);
        this.appointments.add(appointment);
    }

    public static void main(String[] args) {

    }
}



