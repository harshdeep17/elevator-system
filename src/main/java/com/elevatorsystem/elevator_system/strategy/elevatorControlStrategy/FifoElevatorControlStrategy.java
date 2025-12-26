package com.elevatorsystem.elevator_system.strategy.elevatorControlStrategy;

import com.elevatorsystem.elevator_system.model.Elevator;

import java.util.Optional;

public class FifoElevatorControlStrategy implements ElevatorControlStrategy{
    @Override
    public int getNextFloor(Elevator elevator) {
        return elevator.getPendingRequests().isEmpty() ? elevator.getCurrFloor() : elevator.getPendingRequests().pollLast();
    }
}
