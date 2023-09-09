package org.javaguru.mentor.lesson_3.lessoncode;

import java.util.Date;

public class FlightTicket {

    String departure;
    String destination;
    Date departureDateTime;
    Date arrivalDateTime;

    public FlightTicket(String departure, String destination, Date departureDateTime, Date arrivalDateTime) {
        this.departure = departure;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
    }

}
