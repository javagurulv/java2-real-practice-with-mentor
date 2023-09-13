package org.javaguru.mentor.lesson_3.lessoncode;

import java.util.Date;
import java.util.GregorianCalendar;

public class AirBalticApp {

    public static void main(String[] args) {
        GregorianCalendar departureDateTime = new GregorianCalendar(2023, 05, 19, 23, 59);
        FlightTicket testTicket = new FlightTicket("RIX", "ABC", departureDateTime.getGregorianChange(), new Date());

        System.out.println(testTicket.departureDateTime);
        System.out.println(testTicket.arrivalDateTime);
    }
}
