package com.elevatorsystem.elevator_system.strategy.elevatorSelectionStrategy;

import com.elevatorsystem.elevator_system.model.Elevator;
import com.elevatorsystem.elevator_system.model.ExternalRequest;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class NearestIdleElevatorStrategy implements ElevatorSelectionStrategy {
    private List<Elevator> elevators;

    public NearestIdleElevatorStrategy(List<Elevator> elevators){
        this.elevators = elevators;
    }

    @Override
    public Optional<String> selectElevator(ExternalRequest externalRequest) {
        return elevators.stream()
                .filter(elevator -> elevator.isAvailableForAssignment())
                .min(Comparator.comparingInt(e-> Math.abs(e.getCurrFloor() - externalRequest.getSrcFloor())))
                .map(elevator -> elevator.getId().toString());
    }

}
