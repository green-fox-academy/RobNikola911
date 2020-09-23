package Reservations;


import java.util.Random;

public class Reservation implements ReservationIface {
    private final DOW dayOfWeek;
    private String reservationCode;

    Random random = new Random();

    public Reservation() {
        this.reservationCode = "";
        for (int i = 0; i < 8; i++) {
            String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            this.reservationCode += alphaNumericString.charAt(random.nextInt(alphaNumericString.length()));
        }
        DOW[] dow = {DOW.MON, DOW.TUE, DOW.WED, DOW.THU, DOW.FRI, DOW.SAT, DOW.SUN};
        dayOfWeek = dow[random.nextInt(dow.length)];
    }


    @Override
    public String getDowBooking() {
        return dayOfWeek.toString();
    }

    @Override
    public String getCodeBooking() {
        return this.reservationCode;
    }

}

