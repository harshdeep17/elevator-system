package com.elevatorsystem.elevator_system.strategy.elevatorSelectionStrategy;

import com.elevatorsystem.elevator_system.model.ExternalRequest;

import java.util.Optional;

public interface ElevatorSelectionStrategy {
    Optional<String> selectElevator(ExternalRequest externalRequest);
}
