package VehicleRentalSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Vehicle> vehicles= addVehicle();
        List<User> users =  addUser();
        List<Store> stores = addStores(vehicles);

        RentalSystem rentalSystem = new RentalSystem(users, stores);

        //first user arrivess
        User user = users.get(0);

        System.out.println("User arrived: " + user.getUserName());

        Location location = new Location("PRo4 PG", "bangalore", 560032, "Karnataka");
        Store store = rentalSystem.getStoreWithLocation(location);

        if (store == null) {
            System.out.println("No store found at location!");
            return;
        }

        System.out.println("Store found at location: " + location.getAddress());

        // vehicles with vehicle type

        List<Vehicle> vehicleList  = store.getVehicles(VehicleType.CAR);
        System.out.println("Vehicles available of type CAR: " + vehicleList.size());

        if (vehicleList.isEmpty()) {
            System.out.println("No cars available to reserve!");
            return;
        }

        //3.reserving the particular vehicle
        Reservation reservation = store.createReservation(vehicleList.get(0), user);

        System.out.println("Vehicle reserved with ID: " + reservation.reservationId);

        //4. generate the bill

        Bill bill = new Bill(reservation);
        System.out.println("Bill generated. Amount: ₹" + bill.amount + " | Paid: " + bill.isPaid);

    }


    public static List<Vehicle> addVehicle(){

        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle1 = new Vehicle(1, VehicleType.CAR, "UP14AQ78", State.ACTIVE, 10000);

        Vehicle vehicle2 = new Vehicle(2, VehicleType.BIKE, "AN1223", State.ACTIVE, 12213);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        return vehicles;
    }

    public static List<User> addUser()
    {
        List<User> users = new ArrayList<>();
        User user1 = new User(1, "Ayush","UPL2122");
        User user2 = new User(2, "Abish","KL12133");

        users.add(user1);
        users.add(user2);

        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles)
    {
        List<Store> stores = new ArrayList<>();
        Store store1 = new Store();
        store1.storeId = 1;
        store1.setVehicles(vehicles);
        store1.location = new Location("PRo4 PG", "bangalore", 560032, "Karnataka");
        stores.add(store1);
        return stores;
    }




}
