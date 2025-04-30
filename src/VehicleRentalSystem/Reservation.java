package VehicleRentalSystem;

import java.util.Date;

public class Reservation {

    int reservationId;
    Date bookedFrom;
    Date bookedTill;
    Location location;
    User user;
    Vehicle vehicle;
    Status status;


    public void createReserve(Vehicle vehicle, User user) {

        this.reservationId = (int)(Math.random()*100);
        this.user = user;
        this.vehicle = vehicle;
        this.status = Status.SCHEDULED;
    }
}
