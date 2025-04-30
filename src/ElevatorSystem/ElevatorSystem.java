package ElevatorSystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ElevatorSystem {

    Elevator[] elevators;
    ExecutorService elevatorPool;

    public ElevatorSystem(int numElevator)
    {
        elevators = new Elevator[numElevator];
        elevatorPool = Executors.newFixedThreadPool(numElevator);
        for(int i=0;i<numElevator;i++)
        {
            elevators[i] = new Elevator(i);
            elevatorPool.submit(elevators[i]); //run elevators in parallel
        }
    }

    public void requestElevator(int sourceFloor, int destinationFloor)
    {
        Request request = new Request(sourceFloor, destinationFloor);
        Elevator bestElevator = findClosestElevator(sourceFloor, destinationFloor);

        if(bestElevator!=null)
        {
            bestElevator.handleRequest(request);
        }else{
            System.out.println("Can't find any elevator");
        }
    }

    private Elevator findClosestElevator(int sourceFloor, int destinationFloor)
    {
        int bestScore = Integer.MAX_VALUE;
        Elevator bestElevator = null;
        Direction requestDirection  = sourceFloor < destinationFloor ?Direction.UP:Direction.DOWN;

        for(Elevator elevator : elevators)
        {
            int score =0;
            if(elevator.direction == Direction.IDLE)
            {
                // best priority
                score=1;
            }else if(elevator.direction == requestDirection)
            {
                if((requestDirection == Direction.UP && elevator.currentFloor <=sourceFloor) ||
                        (requestDirection == Direction.DOWN && elevator.currentFloor >=sourceFloor))
                {
                    //on the way
                    score=0;
                }else{
                    //opposite direction
                    score=2;
                }
            }else {
                score = 3;
            }

            score+=Math.abs(elevator.currentFloor - sourceFloor);

            if(score < bestScore)
            {
                bestScore = score;
                bestElevator = elevator;
            }
        }
        return bestElevator;
    }

    public void shutdown()
    {
        elevatorPool.shutdownNow(); //Graceful shutdown when needed
    }

}
