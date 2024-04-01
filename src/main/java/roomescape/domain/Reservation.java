
package roomescape.domain;

public class Reservation {

    private final Long id;
    private final String name;
    private final String date;
    private final String time;

    public Reservation(Long id, String name, String date, String time) {
=======
package roomescape;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private Long id;
    private String name;
    private LocalDate date;
    private LocalTime time;

    public Reservation(){
    }

    public Reservation(Long id, String name, LocalDate date, LocalTime time){

        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public static Reservation of(long id, String name, String date, String time) {
        return new Reservation(id, name, date, time);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public LocalDate getDate(){
        return date;
    }
    public String getTime(){
        return time.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public static Reservation toEntity(Reservation reservation, Long id) {
        return new Reservation(id, reservation.name, reservation.date, reservation.time);
    }
}