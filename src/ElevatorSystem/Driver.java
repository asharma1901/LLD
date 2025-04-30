package ElevatorSystem;

public class Driver {

    public static void main(String[] args) throws InterruptedException {
        ElevatorSystem elevatorSystem = new ElevatorSystem(2);

        elevatorSystem.requestElevator(0,5);
        elevatorSystem.requestElevator(6,7);
        elevatorSystem.requestElevator(3,1);
        elevatorSystem.requestElevator(2,6);


        Thread.sleep(5000);

        elevatorSystem.shutdown(); // gracefully stop threads
    }
}
