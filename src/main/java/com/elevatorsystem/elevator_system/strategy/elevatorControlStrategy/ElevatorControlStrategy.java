package com.elevatorsystem.elevator_system.strategy.elevatorControlStrategy;

import com.elevatorsystem.elevator_system.model.Elevator;
import com.elevatorsystem.elevator_system.model.InternalRequest;

import java.util.Optional;

public interface ElevatorControlStrategy {
    int getNextFloor(Elevator elevator);
}
