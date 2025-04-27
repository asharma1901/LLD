package ParkingLotSystem;

import ParkingLotSystem.vehicle.Vehicle;
import ParkingLotSystem.vehicle.VehicleType;

public class ParkingSpot {

    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailable()
    {
        return parkedVehicle==null;
    }

    public synchronized void parkVehicle(Vehicle vehicle)
    {
        if( isAvailable() && vehicle.getVehicleType()==vehicleType)
        {
            parkedVehicle=vehicle;
        }else{
            throw new IllegalArgumentException("Invalid vehicle type or spot filled up.");
        }
    }

    public synchronized void unParkVehicle()
    {
        parkedVehicle = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

}
