package VehicleRentalSystem;

public class Bill {

    Reservation reservation;
    boolean isPaid;
    double amount;

    Bill(Reservation reservation)
    {
        this.reservation = reservation;
        this.amount =   computeBillAmount();
        this.isPaid = true;
    }

    private double computeBillAmount() {

        return 100.0;
    }
}
