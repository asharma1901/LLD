package ParkingLotSystem;

import ParkingLotSystem.vehicle.Vehicle;
import ParkingLotSystem.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private final int levelNumber;
    List<ParkingSpot> parkingSpotList;

    public Level(int levelNumber, int numSpots) {
        this.levelNumber = levelNumber;
        this.parkingSpotList = new ArrayList<>(numSpots);

        int numCars = (int)(numSpots * 0.50);
        int numBikes = (int)(numSpots * 0.40);
        int numTrucks = numSpots - numCars - numBikes;

        int spotNumber = 1;
        for(int i = 1;i<=numCars;i++)
        {
            parkingSpotList.add(new ParkingSpot(spotNumber++, VehicleType.CAR));
        }

        for(int i = 1; i<=numBikes;i++)
        {
            parkingSpotList.add(new ParkingSpot(spotNumber++, VehicleType.MOTORCYCLE));
        }

        for(int i= 1; i<=numTrucks;i++)
        {
            parkingSpotList.add(new ParkingSpot(spotNumber++, VehicleType.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle)
    {
        for(ParkingSpot spot : parkingSpotList){
            if(spot.isAvailable() && spot.getVehicleType()== vehicle.getVehicleType()){
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle)
    {
        for(ParkingSpot spot: parkingSpotList)
        {
            if(!spot.isAvailable() && spot.getVehicleType() == vehicle.getVehicleType())
            {
                spot.unParkVehicle();
                return true;
            }

        }
        return false;
    }

    public void displayAvailability(){
        System.out.println("Level " + levelNumber + " Availability:");
        for (ParkingSpot spot : parkingSpotList) {
            System.out.println("Spot " + spot.getSpotNumber() + ": " + (spot.isAvailable() ? "Available For"  : "Occupied By ")+" "+spot.getVehicleType());
        }
    }



}
