package ParkingLotSystem;

import ParkingLotSystem.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final List<Level> levels;
    private static ParkingLot instance;

    private ParkingLot() {
        levels = new ArrayList<>();
    }
    public static synchronized ParkingLot getInstance() {
        if(instance==null) {
            instance = new ParkingLot();

        }
        return instance;
    }

    public void addLevel(Level level){
        levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(Level level : levels) {
            if(level.parkVehicle(vehicle)){
                System.out.println("Vehicle Parked Successfully");
                return true;
            }
        }
        System.out.println("cant park vehicle");

        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle){

        for(Level level : levels){
            if(level.unParkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        for(Level level : levels){
            level.displayAvailability();
        }
    }
}
