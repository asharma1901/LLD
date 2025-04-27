package ParkingLotSystem;

import ParkingLotSystem.vehicle.Car;
import ParkingLotSystem.vehicle.MotorCycle;
import ParkingLotSystem.vehicle.Truck;
import ParkingLotSystem.vehicle.Vehicle;

public class Driver {
    public static void main(String[] args) {

        ParkingLot parkingLot  = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 10));
        parkingLot.addLevel(new Level(2, 8));

        Vehicle car1 = new Car("MH1234");
        Vehicle car2= new Car("MH1234");
        Vehicle car3 = new Car("MH1234");
        Vehicle car4 = new Car("MH1234");
        Vehicle car5 = new Car("MH1234");
        Vehicle car6 = new Car("MH1234");
        Vehicle truck = new Truck("XYS1321");
        Vehicle motorcycle = new MotorCycle("UP12AQ990");

        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(car3);
        parkingLot.parkVehicle(car4);
        parkingLot.parkVehicle(car5);
        parkingLot.parkVehicle(car6);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);

        parkingLot.displayAvailability();

        parkingLot.unParkVehicle(motorcycle);
        parkingLot.unParkVehicle(car1);

        parkingLot.displayAvailability();
    }
}
