package com.elevatorsystem.elevator_system.strategy.elevatorSelectionStrategy;

import com.elevatorsystem.elevator_system.enums.ElevatorDirection;
import com.elevatorsystem.elevator_system.model.Elevator;
import com.elevatorsystem.elevator_system.model.ExternalRequest;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DirectionAwareElevatorStrategy implements ElevatorSelectionStrategy{
    private List<Elevator> elevators;

    public DirectionAwareElevatorStrategy(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    @Override
    public Optional<String> selectElevator(ExternalRequest externalRequest) {
        return elevators.stream()
                .filter(elevator -> elevator.getElevatorDirection() == externalRequest.getDirectionToGo())
                .filter(elevator ->
                        (elevator.getElevatorDirection() == ElevatorDirection.UP &&
                                elevator.getCurrFloor() <= externalRequest.getSrcFloor())
                     || (elevator.getElevatorDirection() == ElevatorDirection.DOWN &&
                                elevator.getCurrFloor() >= externalRequest.getSrcFloor()))
                .min(Comparator.comparingInt(elevator -> elevator.getCurrFloor() - externalRequest.getSrcFloor()))
                .map(elevator -> elevator.getId().toString());
    }
}
