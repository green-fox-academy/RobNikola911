package Reservations;

import java.util.ArrayList;
import java.util.List;

public class ReservationMain {
    public static void main(String[] args) {


        List<Reservation> reservations = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            reservations.add(new Reservation());
        }

        for(Reservation bookings: reservations) {
            System.out.println("Booking# " + bookings.getCodeBooking() + " for " + bookings.getDowBooking());
        }
    }
}
