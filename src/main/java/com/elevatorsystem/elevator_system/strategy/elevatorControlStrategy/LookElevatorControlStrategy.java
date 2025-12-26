package com.elevatorsystem.elevator_system.strategy.elevatorControlStrategy;

import com.elevatorsystem.elevator_system.enums.ElevatorDirection;
import com.elevatorsystem.elevator_system.model.Elevator;
import com.elevatorsystem.elevator_system.model.ElevatorController;
import com.elevatorsystem.elevator_system.model.ElevatorState;

import java.util.NavigableSet;
import java.util.Optional;

public class LookElevatorControlStrategy implements ElevatorControlStrategy {

    @Override
    public int getNextFloor(Elevator elevator) {
        ElevatorController elevatorController = elevator.getElevatorController();
        ElevatorState elevatorState = elevatorController.getElevatorState();
        int currentFloor = elevatorState.getCurrFloor();
        ElevatorDirection direction = elevator.getElevatorDirection();
        NavigableSet<Integer> stops = elevator.getPendingRequests();

        if (stops.isEmpty()) {
            return currentFloor;
        }

        if (direction == ElevatorDirection.UP) {
            Integer next = stops.higher(currentFloor);
            if (next != null) {
                return next; // ascending
            }
            // reverse direction
            elevatorState.setElevatorDirection(ElevatorDirection.DOWN);
            return stops.last(); // descending start
        }

        if (direction == ElevatorDirection.DOWN) {
            Integer next = stops.lower(currentFloor);
            if (next != null) {
                return next; // descending
            }
            // reverse direction
            elevatorState.setElevatorDirection(ElevatorDirection.UP);
            return stops.first(); // ascending start
        }

        // initial state (IDLE)
        return stops.first();
    }
}
