package VehicleRentalSystem;

public class Vehicle {

    int vehicleId;
    VehicleType vehicleType;
    String plateNumber;
    int kmDriven;
    State state;

    public Vehicle(int vehicleId, VehicleType vehicleType, String plateNumber, State state, int kmDriven) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.plateNumber = plateNumber;
        this.state = state;
        this.kmDriven = kmDriven;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getKmDriven() {
        return kmDriven;
    }

    public State getState() {
        return state;
    }
}
