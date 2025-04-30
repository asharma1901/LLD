package VehicleRentalSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

    int storeId;
    VehicleInventoryManagement vehicleInventoryManagement;
    Location location;
    List<Reservation> reservationList  = new ArrayList<>();

    public Reservation createReservation(Vehicle vehicle, User user)
    {
        Reservation reservation = new Reservation();
        reservation.createReserve(vehicle, user);
        reservationList.add(reservation);
        return reservation;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        vehicleInventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return vehicleInventoryManagement.getVehicleList().stream().filter(v -> v.getVehicleType()==vehicleType).collect(Collectors.toList());
    }

    public boolean completeReservation(int reservationID) {
        return true;
    }




}
