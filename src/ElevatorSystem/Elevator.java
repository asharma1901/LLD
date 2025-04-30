package ElevatorSystem;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Elevator implements Runnable{

    int id;
    int currentFloor;
    Direction direction;
    Queue<Request> requestQueue;


    public Elevator(int id)
    {
        this.id=  id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.requestQueue = new ConcurrentLinkedQueue<>();
    }


    public void handleRequest(Request request)
    {
        System.out.println("Elevator  "  + id  + "  current Floor is " + currentFloor);
        requestQueue.add(request);
        processRequests();
    }

    public void run() {

        while(true)
        {
            if(!requestQueue.isEmpty())
            {
                processRequests();
            }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

    }

    private void processRequests() {

        while(!requestQueue.isEmpty())
        {
            Request currentRequest  = requestQueue.poll();
            System.out.println("Elevator " + id +  " is processing request " + currentRequest.sourceFloor + " ->  " +  currentRequest.destinationFloor);
            moveToFloor(currentRequest.sourceFloor);
            moveToFloor(currentRequest.destinationFloor);
        }

        direction =Direction.IDLE;
        System.out.println("Elevator " + id + "  now IDLE at floor " + currentFloor);
    }

    private void moveToFloor(int targetFloor) {

        if (currentFloor < targetFloor) {
            direction = Direction.UP;
            while (currentFloor < targetFloor) {
                currentFloor++;
            }
        } else if (currentFloor > targetFloor) {
            direction = Direction.DOWN;
            while (currentFloor > targetFloor) {
                currentFloor--;
            }
        } else {

            direction = Direction.IDLE;
            System.out.println("Elevator " + id + "  already at floor " + currentFloor);
        }
    }

}
