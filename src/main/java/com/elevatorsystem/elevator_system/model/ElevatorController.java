package com.elevatorsystem.elevator_system.model;

import com.elevatorsystem.elevator_system.enums.ElevatorDirection;
import com.elevatorsystem.elevator_system.enums.ElevatorStatus;
import com.elevatorsystem.elevator_system.strategy.elevatorControlStrategy.ElevatorControlStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.NavigableSet;
import java.util.TreeSet;

@Getter
@Setter
public class ElevatorController {
    private ElevatorControlStrategy elevatorControlStrategy;
    private ElevatorState elevatorState;

    private final NavigableSet<Integer> pendingStops = new TreeSet<>();

    public ElevatorController(ElevatorControlStrategy elevatorControlStrategy,
                              ElevatorState elevatorState) {
        this.elevatorControlStrategy = elevatorControlStrategy;
        this.elevatorState = elevatorState;
    }

    public boolean isAvailableForAssignment(){
        return elevatorState.getElevatorStatus() == ElevatorStatus.IDLE;
    }

    public void addStop(int floor) {
        pendingStops.add(floor);
        elevatorState.setElevatorStatus(ElevatorStatus.MOVING);
    }

    public void onFloorReached(int floor) {
        pendingStops.remove(floor);

        if (pendingStops.isEmpty()) {
            elevatorState.setElevatorStatus(ElevatorStatus.IDLE);
            elevatorState.setElevatorDirection(ElevatorDirection.IDLE);
        }
    }

    public void moveToFloor(Elevator elevator){
        if (elevatorState.getElevatorStatus() == ElevatorStatus.IDLE) {
            return;
        }

        int nextFloor = elevatorControlStrategy.getNextFloor(elevator);

        elevatorState.setCurrFloor(nextFloor);

        // Remove reached stop
        onFloorReached(nextFloor);
    }
}
